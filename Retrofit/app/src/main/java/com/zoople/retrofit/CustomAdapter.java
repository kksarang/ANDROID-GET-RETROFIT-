package com.zoople.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<Model>datalist;
    private Context context;
    public CustomAdapter(MainActivity mainActivity, List<Model> datalist) {
        this.context = mainActivity;
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rowlist,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(datalist.get(position).getUserid().toString());
        holder.title.setText(datalist.get(position).getId().toString());
        holder.body.setText(datalist.get(position).getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView title;
        TextView body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textid);
            title = itemView.findViewById(R.id.texttitle);
            body = itemView.findViewById(R.id.textbody);




        }
    }
}
