package com.example.week4_lec8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG ,"onCreate:");
    }

    public void LaunchActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart: ");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");     
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }
}