package com.example.z245379.test.util;

import android.app.Application;
import android.content.Context;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    private ProductService productService;
    private Scheduler scheduler;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context){
        return AppController.get(context);
    }

    public ProductService getProductService() {
        if(productService == null)
            productService = ApiFactory.create();
        return productService;
    }

    public Scheduler subscribeScheduler(){
        if(scheduler == null)
            scheduler = Schedulers.io();
        return  scheduler;
    }

    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    public void setScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }
}
