package com.example.z245379.test.util;



import com.example.z245379.test.model.Product;

import retrofit2.http.GET;
import retrofit2.http.Url;
import io.reactivex.Observable;

public interface ProductService {

    @GET
    Observable<Product>fetchProducts(@Url String url);

}
