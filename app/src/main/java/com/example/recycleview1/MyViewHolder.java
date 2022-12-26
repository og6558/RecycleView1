package com.example.recycleview1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView1;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.textView);
    }
}
