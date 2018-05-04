package com.example.z245379.test.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable{

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("pricd") public String price;
    @SerializedName("shortDescription") public String shortDescription;
    @SerializedName("thumbnailImage") public String thumbnailImage;

}
