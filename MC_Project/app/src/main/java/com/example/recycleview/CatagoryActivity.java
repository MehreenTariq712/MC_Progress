package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CatagoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        /////// banner slider
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.drawable.jarman,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.bully,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.dogmth,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.greyhound,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.jarmmann,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.jermanpub,"#077AE4"));

        //////// banner slider

        /////Horizontal product layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.jarman,"Bull Buffaloo","Full Black","Rs.450,000"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bully,"Sahiwali","Red Coat","Rs.599,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.dogmth,"Sahiwali","White","Rs.570,000"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.jermanpub,"Big","Male","Rs.850,000"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.greyhound,"Male Goat","Red","Rs.140,000"));
        /////Horizontal product layout


        ///////////////////////////////////
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    public boolean onOptionItemSelected(MenuItem item){
        int id=item.getGroupId();
        if(id==R.id.main_search_icon){

            //todo:search
            return true;
        }else if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}