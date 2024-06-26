package com.example.fitnessx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding3);



        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton boarding3 = findViewById(R.id.onBoarding3);
        boarding3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Onboarding3.this,Onboarding4.class);
                startActivity(i);
            }
        });
    }
}