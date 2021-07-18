package com.zoople.retrofit1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Custemadapter extends RecyclerView.Adapter<Custemadapter.ViewModel> {
    Context context;

    List<Model> datalist;

    public Custemadapter(Context context, List<Model> datalist) {
       this.context=context;
       this.datalist=datalist;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewModel(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
    holder.textView1.setText(datalist.get(position).getId().toString());
    holder.textView2.setText(datalist.get(position).getUserId().toString());
    holder.textView3.setText(datalist.get(position).getTitle().toString());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {

       TextView textView1,textView2,textView3;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);

        }
    }
}
