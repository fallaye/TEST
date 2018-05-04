package com.example.z245379.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse {

    @SerializedName("results") private List<Product> productList;

    public List<Product> getProductList(){return productList;}

    public void  setProductList(List<Product> mProductList) {this.productList = mProductList;}
}
