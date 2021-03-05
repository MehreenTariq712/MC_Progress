package com.example.assignment72;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] contacts={"Dawood","Iffi","Wahab","Charlie","Abdullah"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.listViewID);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,contacts
        );
       mListView.setAdapter(adapter);
       registerForContextMenu(mListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        menu.setHeaderTitle("Set Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.callAction) {
            Toast.makeText(this, "Call Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.SMSAction) {
            Toast.makeText(this, "Sms Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }


    }
}
