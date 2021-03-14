package com.example.assignment62;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String title;
    String author;
    String publish;
ArrayList<String> desc=new ArrayList<>();
    ArrayList<String> newsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getNews();
        news_fragment fragment=new news_fragment(newsList);

        setContentView(R.layout.activity_main);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.container,fragment);
        transaction.commit();

    }
    public void getNews()
    {

        String json;
        try{
            InputStream is=getAssets().open("news.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                newsList.add(obj.getString("category"));
            }
            Toast.makeText(getApplicationContext(),newsList.toString(),Toast.LENGTH_LONG).show();




        }catch(IOException a)
        {
            a.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void f1(String ab) {
        String json;
        try{
            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
            InputStream is=getAssets().open("news.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                if(obj.getString("category").equals(ab))
                {
                    desc.add(obj.getString("description"));
                }

            }
            Toast.makeText(getApplicationContext(),desc.toString(),Toast.LENGTH_LONG).show();




        }catch(IOException a)
        {
            a.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        headlines_fragment fragment1=new headlines_fragment(desc);
        FragmentManager manager1=getSupportFragmentManager();
        FragmentTransaction t=manager1.beginTransaction();
        t.replace(R.id.container,fragment1);
        t.commit();
    }

    public void f2(String ab) {
        String json;
        try{
            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
            InputStream is=getAssets().open("news.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                if(obj.getString("description").equals(ab))
                {
                   title=obj.getString("title");
                   author=obj.getString("author");
                   publish=obj.getString("publishedAt");
                }

            }
            Toast.makeText(getApplicationContext(),desc.toString(),Toast.LENGTH_LONG).show();




        }catch(IOException a)
        {
            a.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        detailed_news fragment1=new detailed_news();
        FragmentManager manager1=getSupportFragmentManager();
        FragmentTransaction t=manager1.beginTransaction();
        Bundle b2=new Bundle();
        b2.putString("title",title);
        b2.putString("author",author);
        b2.putString("publish",publish);
        fragment1.setArguments(b2);
        t.replace(R.id.container,fragment1);
        t.commit();


    }
}
