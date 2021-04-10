package com.example.databasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
  Button buttonadd,buttonview,buttondelete;
   EditText editName,editAge,editDel;
   Switch aSwitch;
   ListView listViewDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd=findViewById(R.id.buttonAdd);
        buttonview=findViewById(R.id.buttonView);
        buttondelete=findViewById(R.id.buttonDel);
        editDel=findViewById(R.id.editTextDel);
        editName=findViewById(R.id.editTextName);
        editAge=findViewById(R.id.editTextAge);
        aSwitch=findViewById(R.id.switchisActive);
listViewDetail=findViewById(R.id.listviewDetails);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;
            @Override
            public void onClick(View v) {



                    customerModel=new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()),aSwitch.isChecked(),1);
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                boolean b = dbHelper.addCustomer(customerModel);

            }
        });
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                List<CustomerModel> allcustomers=dbHelper.getAllRecords();
                //Toast.makeText(MainActivity.this,allcustomers.toString(),Toast.LENGTH_SHORT).show();
                ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,allcustomers);
                listViewDetail.setAdapter(arrayAdapter);
            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                Integer deletedRows=dbHelper.deleteData(editDel.getText().toString());
                if(deletedRows>0)
                {
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}