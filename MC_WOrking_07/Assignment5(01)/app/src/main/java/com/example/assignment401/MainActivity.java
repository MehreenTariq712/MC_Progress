package com.example.assignment401;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ListView listView;
        String sTitle[]={"Dawood","CHarlie","Abdullah","Irfan","Wahab"};
        String sDescription[]={"Male","Male","Male","Male","Male"};
        int image[]={R.drawable.contact,R.drawable.contact,R.drawable.contact,R.drawable.contact,R.drawable.contact};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        MyAdapter myAdapter=new MyAdapter(this,sTitle,sDescription,image);
        listView.setAdapter(myAdapter);

    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter(Context c,String title[],String description[],int imgs[])
        {
            super(c,R.layout.row,R.id.textView1,title);
            this.context=c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImgs=imgs;

        }
        class MyViewHolder
        {
            ImageView myImage;
            TextView myTitle;
            TextView myDescription;
            MyViewHolder(View v)
            {
                myImage=v.findViewById(R.id.image);
                myTitle=v.findViewById(R.id.textView1);
                myDescription=v.findViewById(R.id.textView2);
            }
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View row=convertView;
            MyViewHolder holder=null;
            if(row==null)
            {
                LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=layoutInflater.inflate(R.layout.row,parent,false);
                holder=new MyViewHolder(row);
                row.setTag(holder);
            }
            else
            {
                holder=(MyViewHolder) row.getTag();
            }


            holder.myImage.setImageResource(rImgs[position]);
            holder.myTitle.setText(rTitle[position]);
            holder.myDescription.setText(rDescription[position]);
            return row;
        }
    }
}
