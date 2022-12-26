package com.example.recycleview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<item> items;
    private ItemClickListner itemClickListner;

    public MyAdapter(Context context , List<item> items, ItemClickListner itemClickListner) {
        this.context = context;
        this.items = items;
        this.itemClickListner = itemClickListner;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(items.get(position).getNum());
        holder.itemView.setOnClickListener(view -> {itemClickListner.onitemclick(position);});

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
