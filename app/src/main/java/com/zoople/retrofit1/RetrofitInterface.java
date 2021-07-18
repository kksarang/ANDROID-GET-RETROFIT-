package com.zoople.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("albums")
    Call<List<Model>>getdata();
}
