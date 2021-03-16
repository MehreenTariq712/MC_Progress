package com.example.assignment9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    String Url="https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fb%2Fb6%2FImage_created_with_a_mobile_phone.png&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FImage&tbnid=nH5liarSz56duM&vet=12ahUKEwiOjp3GocfpAhUP0BoKHZO1DjUQMygAegUIARC0AQ..i&docid=0JWe7yDOKrVFAM&w=4000&h=3000&q=image&ved=2ahUKEwiOjp3GocfpAhUP0BoKHZO1DjUQMygAegUIARC0AQ";
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        //Url=editText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsycTask asycTask=new AsycTask();
                asycTask.execute(Url);
            }
        });
    }
    class AsycTask extends AsyncTask<String,Integer,Integer>
    {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Download In Progress...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(String... voids) {
            String path=voids[0];
            int file_length=0;
            try {
                URL url=new URL(path);
                URLConnection urlConnection=url.openConnection();
                urlConnection.connect();
                file_length=urlConnection.getContentLength();
                InputStream inputStream=new BufferedInputStream(url.openStream());
                Toast.makeText(getApplicationContext(),file_length,Toast.LENGTH_LONG).show();
                publishProgress(file_length);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file_length;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Integer aVoid) {
           progressDialog.hide();
            Toast.makeText(getApplicationContext(),aVoid,Toast.LENGTH_LONG).show();
        }
    }
}
