package com.example.z245379.test.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.z245379.test.model.Product;

public class ProductItemViewModel extends BaseObservable {

    private Product product;
    private Context context;

    public ProductItemViewModel(Product product){
        this.product = product;
        //this.context = context;
    }

    public String getId() {
        return product.getId();
    }
    public String getName() {
        return product.getName();
    }
    public String getPrice() {
        return product.getPrice();
    }

    public String getDescription() {
        return product.getShortDescription();
    }
    //public String getImage() {
        //return product.getThumbnailImage();
    //}
    //@BindingAdapter("thumbnailImage") public static void setImageUrl(
            //ImageView imageView, String url){
     //   Glide.with(imageView.getContext()).load(url).into(imageView);
    //}


    public void setProduct(Product product){
        this.product = product;
        notifyChange();
    }


}
