package com.example.fitnessx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BeginnerExercise extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_exercise);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the decor view of the activity
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        List<Item1> items = new ArrayList<Item1>();
        items.add(new Item1("Warm Up","05:00",R.drawable.warmup));
        items.add(new Item1("Jumping JacK","12x",R.drawable.jumpingjacl));
        items.add(new Item1("Skipping","05:00",R.drawable.skipping));
        items.add(new Item1("Squats","20x",R.drawable.squats));

        RecyclerView recyclerView = findViewById(R.id.beginnerRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapterBeginner adapter = new MyAdapterBeginner(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyAdapterBeginner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Item1 clickedItem = items.get(position);
                String itemName = clickedItem.getName();
                int itemImage = clickedItem.getImage();

                switch (itemName) {
                    case "Warm Up":
                        // Handle Warm Up item click
                        Intent intent1 = new Intent(BeginnerExercise.this, home.class);
                        intent1.putExtra("itemName", itemName);
                        intent1.putExtra("itemImage", itemImage);
                        startActivity(intent1);
                        break;
                    case "Jumping JacK":
                        // Handle Jumping Jack item click
                        Intent intent2 = new Intent(BeginnerExercise.this, JumpingJack.class);
                        intent2.putExtra("itemName", itemName);
                        intent2.putExtra("itemImage", itemImage);
                        startActivity(intent2);
                        break;
                    case "Skipping":
                        // Handle Skipping item click
                        Intent intent3 = new Intent(BeginnerExercise.this, SplashScreen.class);
                        intent3.putExtra("itemName", itemName);
                        intent3.putExtra("itemImage", itemImage);
                        startActivity(intent3);
                        break;
                    case "Squats":
                        // Handle Squats item click
                        Intent intent4 = new Intent(BeginnerExercise.this, ActivityTracker.class);
                        intent4.putExtra("itemName", itemName);
                        intent4.putExtra("itemImage", itemImage);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }
}
