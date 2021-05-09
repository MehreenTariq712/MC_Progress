package com.example.videosinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView=findViewById(R.id.videoView);
videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.plants);
videoView.start();
    }
}