package com.zoople.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("albums")
    Call<List<Model>>getData();
}
