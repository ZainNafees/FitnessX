package com.example.fitnessx;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class StepCounter extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepSensor;
    private TextView stepCountText;
    private Button resetButton;
    private CardView stepCounterCardView;
    private int stepCount;
    private Sensor sSensor;
    private long steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the decor view of the activity
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        stepCountText = findViewById(R.id.stepCount);
        resetButton = findViewById(R.id.resetButton);
        stepCounterCardView = findViewById(R.id.stepCounterCardView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sSensor= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);


        if (stepSensor == null) {
            Toast.makeText(this, "Step sensor not available", Toast.LENGTH_SHORT).show();
            stepCountText.setText("0");
            resetButton.setEnabled(false);
        } else {
            resetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stepCount = 0;
                    stepCountText.setText(String.valueOf(stepCount));
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (stepSensor != null) {
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sSensor != null) {
            sensorManager.registerListener(this, sSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (stepSensor != null) {
            sensorManager.unregisterListener(this);
        }
        if (sSensor != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (stepCount == 0) {
                stepCount = (int) event.values[0];
            }
            int newStepCount = (int) event.values[0] - stepCount;
            stepCountText.setText(String.valueOf(newStepCount));
        }

        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps++;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
