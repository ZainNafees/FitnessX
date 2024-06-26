package com.example.fitnessx;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class JumpingJack extends AppCompatActivity {

    private VideoView videoView;
    private ImageButton btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumping_jack);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the decor view of the activity
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        videoView = findViewById(R.id.video_view);
        btnPrevious = findViewById(R.id.btnPrevious);

        // set click listener for the "Previous" button
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to the previous activity
                onBackPressed();
            }
        });


        String path = "android.resource://" + getPackageName() + "/" + R.raw.jumpingjacks;
        videoView.setVideoURI(Uri.parse(path));

        // create a media controller to play, pause, seek, and adjust volume
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // start playing the video
        videoView.start();

        Button btnWorkout = findViewById(R.id.btnWorkout);
        TextView tvTimer = findViewById(R.id.tv_timer);

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(60000, 1000) { // adjust time duration here
                    public void onTick(long millisUntilFinished) {
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                        tvTimer.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
                    }

                    public void onFinish() {
                        tvTimer.setText("01:00");
                    }
                }.start();
            }
        });
    }
}

