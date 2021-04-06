package com.example.audioamination;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  public void play(View view){
if(player==null)
{
    player=MediaPlayer.create(this,R.raw.alaram);
}
player.start();
 }
    public void pause(View view){
if(player!=null)
    player.pause();
    }
    public void stop(View view){
        if(player!=null){
            player.release();
            player=null;

        }
    }
}