package com.example.fitnessx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class EditProfile extends AppCompatActivity {
    EditText nameEditText;
    ImageView profileImageView;
    Uri newProfileImageUri;
    ImageButton closeBtn;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the decor view of the activity
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        nameEditText = findViewById(R.id.nameEditText);
        profileImageView = findViewById(R.id.profileImageView);
        closeBtn = findViewById(R.id.closeButton);
        saveBtn= findViewById(R.id.saveButton);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges(v);
            }
        });

        // Load the current name and profile image into the UI
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();
            nameEditText.setText(personName);
            Glide.with(this).load(personPhoto).into(profileImageView);
        }

        // Allow the user to select a new profile image
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        });
    }

    // When the user saves their changes, return the new name and profile image URI to the Profile activity
    public void saveChanges(View view) {
        String name = nameEditText.getText().toString();
        if(name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("name", name);
        if (newProfileImageUri != null) {
            returnIntent.putExtra("profileImageUri", newProfileImageUri.toString());
        }
        setResult(RESULT_OK, returnIntent);
        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    // When the user selects a new profile image, update the UI and save the new image URI
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            Glide.with(this).load(imageUri).into(profileImageView);
            newProfileImageUri = imageUri;
        }
    }
}
