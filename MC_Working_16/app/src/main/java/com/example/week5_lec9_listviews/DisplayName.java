package com.example.week5_lec9_listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);

        // Getting Name
        String name = getIntent().getStringExtra("Name");
        // Textview
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
    }
}