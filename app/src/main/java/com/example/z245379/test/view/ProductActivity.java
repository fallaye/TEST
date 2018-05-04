package com.example.z245379.test.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.z245379.test.R;
import com.example.z245379.test.databinding.ActivityProductBinding;
import com.example.z245379.test.util.Constant;
import com.example.z245379.test.viewmodel.ProductViewModel;

import java.net.URI;
import java.util.Observable;
import java.util.Observer;

public class ProductActivity extends AppCompatActivity implements Observer{

    private ActivityProductBinding productActivityBinding;
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initDataBinding();
        //setUpListOfProductView(productActivityBinding.listProduct);
      //  setUpObserver(productViewModel);

    }


    private void initDataBinding(){
        productActivityBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_product);
        productViewModel = new ProductViewModel(this);
     //   productActivityBinding.setProductViewModel(productViewModel);
    }

    private void setUpObserverView(RecyclerView listProduct){
        ProductAdapter productAdapter = new ProductAdapter();
        listProduct.setAdapter(productAdapter);
        listProduct.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ProductViewModel){
//            ProductAdapter productAdapter =
//                    (ProductAdapter) productActivityBinding.listProduct.getAdapter();
            ProductViewModel productViewModel = (ProductViewModel)o;
//            productAdapter.setProductList(productViewModel.getProductList());
        }
    }

    private void startActivityActionView(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constant.BASE_URL)));
    }





}
