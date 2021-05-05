package com.example.recycleview;


import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();

        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Dogs"));
        categoryModelList.add(new CategoryModel("link","Cats"));
        categoryModelList.add(new CategoryModel("link","Hourse"));
        categoryModelList.add(new CategoryModel("link","Birds"));
        categoryModelList.add(new CategoryModel("link","Buffalo"));
        categoryModelList.add(new CategoryModel("link","Cows"));
        categoryModelList.add(new CategoryModel("link","parrot"));
        categoryModelList.add(new CategoryModel("link","All"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /////// banner slider
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.drawable.bull3,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.c1,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.camal1,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.bull1,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.g1,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.c2,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.cow1,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.goat,"#CE0000"));
        sliderModelList.add(new SliderModel(R.drawable.chatra1,"#CE0000"));

        //////// banner slider

        /////Horizontal product layout

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
        /////Horizontal product layout


        ///////////////////////////////////

        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner11,"#BFBEBE"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.dogiadd,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner11,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ///////////////////////////////////;
        return view;
    }
}
