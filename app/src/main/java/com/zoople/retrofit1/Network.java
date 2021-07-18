package com.zoople.retrofit1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        retrofit=new Retrofit.Builder()
               .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
