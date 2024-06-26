package com.example.fitnessx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageButton boarding1 = findViewById(R.id.onBoarding1);
        boarding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Onboarding1.this,Onboarding2.class);
                startActivity(i);
            }
        });

    }
}