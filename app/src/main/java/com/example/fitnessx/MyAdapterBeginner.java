package com.example.fitnessx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterBeginner extends RecyclerView.Adapter<MyViewHolder1> {

    private Context context;
    private List<Item1> items;
    private OnItemClickListener listener;

    public MyAdapterBeginner(Context context, List<Item1> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.item1_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, @SuppressLint("RecyclerView") int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.infoView.setText(items.get(position).getInfo());
        holder.imageView.setImageResource(items.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
