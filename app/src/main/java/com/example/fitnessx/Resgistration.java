package com.example.fitnessx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Resgistration extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText fname, lname, email, password;
    private Button registerBtn;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistration);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the decor view of the activity
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        auth = FirebaseAuth.getInstance();
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.register);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userFName = fname.getText().toString().trim();
                String userLName = lname.getText().toString().trim();
                String userEmail = email.getText().toString().trim();
                String userPass = password.getText().toString().trim();

                if (userFName.isEmpty()) {
                    fname.setError("First Name can't be empty");
                }
                if (userLName.isEmpty()) {
                    lname.setError("Last Name can't be empty");
                }
                if (userEmail.isEmpty()) {
                    email.setError("Email can't be empty");
                }
                if (userPass.isEmpty()) {
                    password.setError("Password can't be empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(userEmail, userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Resgistration.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Resgistration.this, login.class));
                            }
                            else {
                                Toast.makeText(Resgistration.this, "Registration Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Resgistration.this, login.class));
            }
        });
    }
}