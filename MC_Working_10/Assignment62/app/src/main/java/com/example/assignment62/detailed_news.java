package com.example.assignment62;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class detailed_news extends Fragment {
    TextView t1,t2,t3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.deailed_news,container,false);
        t1=v.findViewById(R.id.text1);
        t2=v.findViewById(R.id.text2);
        t3=v.findViewById(R.id.text3);
        Bundle b=getArguments();
        if(b!=null)
        {
            String title=b.getString("title");
            t1.setText(title);
            String author=b.getString("author");
            t2.setText(author);
            String publish=b.getString("publish");
            t3.setText(publish);
        }
        return v;
    }
}
