package com.myblueshare.matrixcalculator.sustainablewalking;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RecordingWalk extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorMan;
    private Sensor sensor;

    private float[] gravity;
    private float accel;
    private float accelCurrent;
    private float accelLast;
    private int steps = 0;
    private TextView stepsLabel;
    private TextView timerLabel;

    //For timer
    private long startTime = 0L;
    private long milliSeconds = 0L;
    private long updatedTime = 0L;
    private long timeSwapBuff = 0L;

    private Handler handle = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_walk);


        startTime = System.currentTimeMillis();
        handle.postDelayed(timer, 0);

        stepsLabel = (TextView) findViewById(R.id.stepsCount);
        sensorMan = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accel = 0.00f;
        accelCurrent = SensorManager.GRAVITY_EARTH;
        accelLast = SensorManager.GRAVITY_EARTH;

        timerLabel = (TextView) findViewById(R.id.textView5);
        stepsLabel = (TextView) findViewById(R.id.stepsCount);

        stepsLabel.setText(steps);

    }

    @Override
    public void onResume() {
        super.onResume();
        sensorMan.registerListener(this, sensor,
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorMan.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            gravity = event.values.clone();
            // Shake detection
            float x = gravity[0];
            float y = gravity[1];
            float z = gravity[2];
            accelLast = accelCurrent;
            accelCurrent = (float) Math.sqrt(x*x + y*y + z*z);
            float changeInAccel = accelCurrent - accelLast;
            accel = accel * 0.8f + changeInAccel;
            // Make this higher or lower according to how much
            // motion you want to detect
            if(accel > 1.25){ //if it shakes
                // it assumes that it is a step
                steps++;
                stepsLabel.setText(steps);
            }
        }
    }

    public void resetClicked(View v){
        //reset shake count
        steps = 0;
        stepsLabel.setText(steps);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // required method not needed but it's there
    }

    public void pauseClicked(View v){
        timeSwapBuff += milliSeconds;
        handle.removeCallbacks(timer);
    }



    private Runnable timer = new Runnable(){
        public void run() {

            milliSeconds = System.currentTimeMillis() - startTime;

            updatedTime = timeSwapBuff + milliSeconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerLabel.setText("TIME: " + mins + ":"
                            + String.format("%02d", secs) + ":"
                            + String.format("%02d", milliseconds));
            handle.postDelayed(this, 0);
        }
    };

}
