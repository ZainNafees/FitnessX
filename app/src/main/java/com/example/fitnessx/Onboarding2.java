package com.example.fitnessx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);



        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton boarding2 = findViewById(R.id.onBoarding2);
        boarding2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Onboarding2.this,Onboarding3.class);
                startActivity(i);
            }
        });
    }
}