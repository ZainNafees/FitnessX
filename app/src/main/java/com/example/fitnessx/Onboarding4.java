package com.example.fitnessx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding4);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageButton boarding4 = findViewById(R.id.onBoarding4);



        boarding4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Onboarding4.this, login.class);
                startActivity(i);
            }
        });
    }
}