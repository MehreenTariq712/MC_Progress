package com.example.recycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFragment extends Fragment {

    public MyOrderFragment() {
        // Required empty public constructor
    }
    private RecyclerView myOrdersRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        myOrdersRecyclerView = view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.bull1,2,"Bull Black","Delivered on Mon,15th Agu 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.camal1,1,"Bowen Camel","Delivered on Fri,15th Agu 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.c1,0,"Sahiwali","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.g1,4,"Rajastani Goat","Delivered on Tue,15th Agu 2020"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

        return view;
    }
}