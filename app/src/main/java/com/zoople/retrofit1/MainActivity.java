package com.zoople.retrofit1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RetrofitInterface retrofitInterface= Network.getRetrofit().create(RetrofitInterface.class);
        Call<List<Model>> call=retrofitInterface.getdata();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()){
                    genaretdata(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
    private void genaretdata(List<Model>datalist){
        recyclerView = findViewById(R.id.recyclerview1);
        Custemadapter custemadapter = new Custemadapter(getApplicationContext(),datalist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(custemadapter);
    }
}