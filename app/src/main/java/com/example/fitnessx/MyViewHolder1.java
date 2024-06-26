package com.example.fitnessx;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder1 extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, infoView;

    public MyViewHolder1(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        infoView = itemView.findViewById(R.id.info);
    }
}
