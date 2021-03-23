package com.example.week5_lec9_listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Getting Views
        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        // ListView
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<String>(); // Empty Array List
        // Initializing Array Adapter
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        // Setting listView
        listView.setAdapter(arrayAdapter);

        // Event Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DisplayName.class);
                intent.putExtra("Name", arrayList.get(position));
                startActivity(intent);
            }
        });
    }

    public void addName(View view) {
        arrayList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
    }
}