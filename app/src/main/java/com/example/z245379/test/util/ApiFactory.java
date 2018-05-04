package com.example.z245379.test.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    public static final String BASE_URL = "http://api.walmartlabs.com/v1/paginated/items?category=3944&specialOffer=rollback&apiKey=jqkppatf3su4ma38cpj3tevh&format=json";

    public static ProductService create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(ProductService.class);

    }


}
