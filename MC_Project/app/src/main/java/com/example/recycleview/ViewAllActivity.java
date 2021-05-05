package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if (layout_code == 0) {

            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.g1, "Goat", 1, "3.5", 145, "Rs.149,999/-", "Rs.169,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.cow, "Shahiwal Bread", 0, "2.5", 65, "Rs.150,000/-", "Rs.180,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.cow1, "Nili Ravi", 1, "4.5", 165, "Rs.200,000/-", "Rs.210,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.camal1, "Camel", 4, "3.4", 205, "Rs.99,999/-", "Rs.105,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.bull1, "Bull Black", 1, "4.7", 175, "Rs.80,000/-", "Rs.90,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.chatra2, "White", 1, "3.5", 145, "Rs.349,999/-", "Rs.459,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.c1, "Male Cow", 0, "2.5", 65, "Rs.950,000/-", "Rs.980,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.g3, "Goat Male", 1, "4.5", 165, "Rs.200,000/-", "Rs.210,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.c2, "Cow", 4, "3.4", 205, "Rs.199,000/-", "Rs.199,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.g1, "Goat", 1, "3.5", 145, "Rs.149,999/-", "Rs.169,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.cow, "Shahiwal Bread", 0, "2.5", 65, "Rs.150,000/-", "Rs.180,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.cow1, "Nili Ravi", 1, "4.5", 165, "Rs.200,000/-", "Rs.210,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.camal1, "Camel", 4, "3.4", 205, "Rs.99,999/-", "Rs.105,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.bull1, "Bull Black", 1, "4.7", 175, "Rs.80,000/-", "Rs.90,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.chatra2, "White", 1, "3.5", 145, "Rs.349,999/-", "Rs.459,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.c1, "Male Cow", 0, "2.5", 65, "Rs.950,000/-", "Rs.980,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.g3, "Goat Male", 1, "4.5", 165, "Rs.200,000/-", "Rs.210,000/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.c2, "Cow", 4, "3.4", 205, "Rs.199,000/-", "Rs.199,999/-", "Cash on delivery"));

            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else if (layout_code == 1) {

            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bull1,"Bull Buffaloo","Full Black","Rs.450,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.c1,"Sahiwali","Red Coat","Rs.599,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.c2,"Sahiwali","White","Rs.570,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.camal1,"Big","Male","Rs.850,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.g1,"Male Goat","Red","Rs.140,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.chatra1,"White Chatra","Long Hight","Rs.110,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bull2,"Bull","Black","Rs.150,00000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.jermanpub,"Pure Pupy","Double Coat","Rs.80,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.chatra2,"Chatra","Big","Rs.150,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bull1,"Bull Buffaloo","Full Black","Rs.450,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.c1,"Sahiwali","Red Coat","Rs.599,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.c2,"Sahiwali","White","Rs.570,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.camal1,"Big","Male","Rs.850,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.g1,"Male Goat","Red","Rs.140,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.chatra1,"White Chatra","Long Hight","Rs.110,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bull2,"Bull","Black","Rs.150,00000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.jermanpub,"Pure Pupy","Double Coat","Rs.80,000"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.chatra2,"Chatra","Big","Rs.150,000"));

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}