package com.example.fitnessx;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class workoutFragment extends Fragment implements MyAdapter.OnItemClickListener {

    public workoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler1);
        ArrayList<Data> data = new ArrayList<>();

        data.add(new Data(R.drawable.gym1, "Beginner"));
        data.add(new Data(R.drawable.gym2, "Intermediate"));
        data.add(new Data(R.drawable.gym3, "Expert"));

        MyAdapter adapter = new MyAdapter(data, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(Data item) {
        // Open new activity with the clicked item's data
        switch (item.getName()) {
            case "Beginner":
                Intent beginnerIntent = new Intent(getActivity(), BeginnerExercise.class);
                beginnerIntent.putExtra("imgResId", item.getImg1());
                beginnerIntent.putExtra("title", item.getName());
                startActivity(beginnerIntent);
                break;
            case "Intermediate":
                Intent intermediateIntent = new Intent(getActivity(), ActivityTracker.class);
                intermediateIntent.putExtra("imgResId", item.getImg1());
                intermediateIntent.putExtra("title", item.getName());
                startActivity(intermediateIntent);
                break;
            case "Expert":
                Intent expertIntent = new Intent(getActivity(), home.class);
                expertIntent.putExtra("imgResId", item.getImg1());
                expertIntent.putExtra("title", item.getName());
                startActivity(expertIntent);
                break;
            default:
                break;
        }
    }
}

