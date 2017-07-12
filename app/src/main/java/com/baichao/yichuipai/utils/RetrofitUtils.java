package com.baichao.yichuipai.utils;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pll on 2017/5/9.
 */

public class RetrofitUtils {


    public static Retrofit getRetrofit(String url, Context context){

//        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .addInterceptor(new SaveCookiesInterceptor(context))
//                .addInterceptor(new AddCookiesInterceptor(context))
//                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }
}
