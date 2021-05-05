package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerView;
    private Button changeOraddNewAddressBtn;
    private Toolbar toolbar;
    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Animal Delivery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deliveryRecyclerView = findViewById(R.id.delivery_recyclerview);
        changeOraddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.g1,"Goat",2,"Rs.114,000/-","Rs.115,000/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.bull1,"Big Bull",0,"Rs.949,999/-","Rs.105,9999/-",1,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.camal1,"Brown Camel",2,"Rs.5,49,999/-","Rs.6,59,999/-",1,2,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 Aminals)","Rs.40,50000/-","Free","Rs.40,50000","Rs.14,999/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOraddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOraddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myAddressesIntent = new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });

    }
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getGroupId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}