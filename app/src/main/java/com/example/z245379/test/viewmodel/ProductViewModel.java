package com.example.z245379.test.viewmodel;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
//import io.reactivex.disposables.Disposable;

import com.example.z245379.test.model.Product;
import com.example.z245379.test.model.ProductResponse;
import com.example.z245379.test.util.AppController;
import com.example.z245379.test.util.Constant;
import com.example.z245379.test.util.ProductService;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ProductViewModel extends Observable{

    private List<Product> productList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public ObservableInt productName;
    public ObservableInt productRecycler;

    public ProductViewModel(@NonNull Context context){
        this.context = context;
        this.productList = new ArrayList<>();

    }

    public void onAppStart(){
        initializeviews();
        fetchProductList();
    }

    public void initializeviews(){
        productRecycler.set(View.GONE);
    }

    private void fetchProductList(){
        AppController appController = AppController.create(context);
        ProductService productService = appController.getProductService();

        Disposable disposable = productService.fetchProducts(Constant.BASE_URL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProductResponse>() {
                    @Override
                    public void accept(ProductResponse productResponse) throws Exception {
                        updateProductDataList(productResponse.getProductList());
                        productName.set(View.GONE);
                        productRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        productName.set(View.VISIBLE);
                        productRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);

    }

    private void updateProductDataList(List<Product> products){
        productList.addAll(products);
        setChanged();
        notifyObservers();
    }

    public List<Product> getProductList(){
        return productList;
    }

    private void unSubscribeFromObservable(){
        if(compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }


}
