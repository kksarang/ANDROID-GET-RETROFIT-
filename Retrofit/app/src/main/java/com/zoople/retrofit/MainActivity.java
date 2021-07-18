package com.zoople.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loding....");
        progressDialog.show();

        ApiInterface apiInterface = Retrofitclint.getClient().create(ApiInterface.class);
        Call<List<Model>>call = apiInterface.getData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
             if (response.isSuccessful()) {
                 gererateData(response.body());
                 progressDialog.dismiss();
             }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "some thing error plz try again", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void gererateData(List<Model>datalist){
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new CustomAdapter(this,datalist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
