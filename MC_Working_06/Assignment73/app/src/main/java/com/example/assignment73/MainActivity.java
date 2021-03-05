package com.example.assignment73;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    Button btpress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.relativeLayout);
        btpress=findViewById(R.id.bt_press);
        btpress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu=new PopupMenu(getApplicationContext(),btpress);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.none:
                                relativeLayout.setBackgroundColor(Color.TRANSPARENT);
                                return true;
                            case R.id.red:
                                relativeLayout.setBackgroundColor(Color.RED);
                                return true;
                            case R.id.green:
                                relativeLayout.setBackgroundColor(Color.GREEN);
                                return true;
                            case R.id.blue:
                                relativeLayout.setBackgroundColor(Color.BLUE);
                                return true;
                        }

                        return false;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }
}
