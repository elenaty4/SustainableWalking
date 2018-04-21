package com.myblueshare.matrixcalculator.sustainablewalking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainWalkActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_walk);
    }

    public void startWalkClick(View v){
        intent = new Intent(this, RecordingWalk.class);
        startActivity(intent);
    }
}
