package com.bigzone.zuoyou.internet;

import com.bigzone.zuoyou.common.MyApp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyRetrofitUtil {

    private static Yukicom yukicom;
    private MyRetrofitUtil(){}
    public static Yukicom getInstance(){
        if (yukicom == null) {
            yukicom = new Retrofit.Builder().baseUrl(MyApp.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build().create(Yukicom.class);
        }
        return yukicom;
    }
}
