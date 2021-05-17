package org.mehreen.alphabetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
Button start;
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mp=MediaPlayer.create(this,R.raw.a);
        setContentView(R.layout.activity_main);



    }

    public void Move(View view) {
        setContentView(R.layout.activity_alphabets);

    }
    public void A_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp=MediaPlayer.create(this,R.raw.a);
        mp.start();
    }
    public void B_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.b);
        mp.start();
    }
    public void F_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.f);
        mp.start();
    }
    public void C_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.c);
        mp.start();
    }
    public void D_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.d);
        mp.start();
    }
    public void E_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.e);
        mp.start();
    }
    public void G_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.g);
        mp.start();
    }
    public void H_Sound(View view) {
        if(mp.isPlaying())
            mp.stop();
        mp = MediaPlayer.create(this,R.raw.h);
        mp.start();
    }

}