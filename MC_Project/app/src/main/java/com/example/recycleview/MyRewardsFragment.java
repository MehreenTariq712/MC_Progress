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


public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardsRecyclerView = view.findViewById(R.id.my_reward_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList =  new ArrayList<>();
        rewardModelList.add(new RewardModel("Buy 1 get 500 Back","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Buy 2 Dogs Pupy get 1 Free","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Cashback","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Discount","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Buy 1 get 500 Back","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Buy 2 Dogs Pupy get 1 Free","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Buy 1 get 500 Back","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));
        rewardModelList.add(new RewardModel("Buy 2 Dogs Pupy get 1 Free","till 2nd Dec 2020","GET 20% CASHBACK on any animal above Rs.50,000/- and below Rs.80,000/-"));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList);
        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        return view;
    }
}