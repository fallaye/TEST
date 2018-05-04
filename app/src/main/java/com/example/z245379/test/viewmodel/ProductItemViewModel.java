package com.example.z245379.test.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.z245379.test.model.Product;

public class ProductItemViewModel extends BaseObservable {

    private Product product;
    private Context context;

    public ProductItemViewModel(Product product, Context context){
        this.product = product;
        this.context = context;
    }

    public String getId() {
        return product.id;
    }
    public String getName() {
        return product.name;
    }
    public String getPrice() {
        return product.price;
    }

    public String getDescription() {
        return product.shortDescription;
    }
    public String getImage() {
        return product.thumbnailImage;
    }
    @BindingAdapter("thumbnailImage") public static void setImageUrl(
            ImageView imageView, String url){
     //   Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    public void setProduct(Product product){
        this.product = product;
        notifyChange();
    }


}
