package com.example.recycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.c1,"Sahiwali Bread",1,"3.5",145,"Rs.449,999/-","Rs.459,999/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.bull1,"Shahiwal Bread",0,"2.5",65,"Rs.550,000/-","Rs.580,000/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.chatra1,"Chatra White",1,"4.5",165,"Rs.200,000/-","Rs.210,000/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.camal1,"Camel",4,"3.4",205,"Rs.599,999/-","Rs.605,000/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.g1,"Male Goat",1,"4.7",175,"Rs.80,000/-","Rs.90,000/-","Cash on delivery"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList,true);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}