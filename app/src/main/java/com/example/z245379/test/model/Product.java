package com.example.z245379.test.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product extends BaseObservable {

    private String id, name, price, shortDescription, thumbnailImage;

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Bindable
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    //@Bindable
    //public String getThumbnailImage() {
        //return thumbnailImage;
    //}

    //public void setThumbnailImage(String thumbnailImage) {
        //this.thumbnailImage = thumbnailImage;
    //}


    @SerializedName("results") private List<Product> productList;

    public List<Product> getProductList(){return productList;}

    public void  setProductList(List<Product> mProductList) {this.productList = mProductList;}
}
