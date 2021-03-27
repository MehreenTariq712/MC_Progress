package com.example.week7_lec14_dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Dialog For Test");
        builder.setMessage("This is Dialog Used for Testing");

        // Adding Button Code
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Positive Btn Clicked", Toast.LENGTH_LONG).show();
            }
        });

        // Adding Negative Btn
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Negative Btn Clicked", Toast.LENGTH_LONG).show();
            }
        });

        // Adding Layout
        builder.setView(R.layout.dialog_layout);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}