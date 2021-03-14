package com.example.assignment62;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class headlines_fragment extends Fragment {
    ArrayList<String> desc;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    public headlines_fragment(ArrayList<String> ab)
    {
desc=ab;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.headlines_fragment,container,false);
        listView=v.findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,desc);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ab=desc.get(position);
                Toast.makeText(getActivity(),ab,Toast.LENGTH_LONG).show();
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.f2(ab);

            }
        });
        return v;
    }
}
