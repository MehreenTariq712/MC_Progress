package com.example.assignment8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private ArrayList<String> sTitle = new ArrayList<>();
    private String[] sDescription={"","",""};
    int image[]={R.drawable.whatsapp,R.drawable.face,R.drawable.youtube};

    public String ab = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        sTitle.add("Whatsapp");
        sTitle.add("Facebook");
        sTitle.add("Youtube");
        MyAdapter myAdapter=new MyAdapter(this,sTitle,sDescription,image);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ab = sTitle.get(position);
                Toast.makeText(getApplicationContext(), ab, Toast.LENGTH_LONG).show();


            }
        });
        registerForContextMenu(listView);
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> rTitle;
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, ArrayList<String> title, String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        class MyViewHolder {
            ImageView myImage;
            TextView myTitle;
            TextView myDescription;

            MyViewHolder(View v) {
                myImage = v.findViewById(R.id.image);
                myTitle = v.findViewById(R.id.textView1);
                myDescription = v.findViewById(R.id.textView2);
            }
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View row = convertView;
            MyViewHolder holder = null;
            if (row == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = layoutInflater.inflate(R.layout.row, parent, false);
                holder = new MyViewHolder(row);
                row.setTag(holder);
            } else {
                holder = (MyViewHolder) row.getTag();
            }


            holder.myImage.setImageResource(rImgs[position]);
            holder.myTitle.setText(rTitle.get(position));
            holder.myDescription.setText(rDescription[position]);
            return row;
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        menu.setHeaderTitle("Want to launch app");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {



        if (ab.equals("Youtube")) {
            if (item.getItemId() == R.id.yes) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(launchIntent);
                return true;
            } else if (item.getItemId() == R.id.no) {
                return true;
            } else {
                return false;
            }
        }
        else if (ab.equals("Facebook")) {
            if (item.getItemId() == R.id.yes) {
                boolean facebookAppFound = false;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
                for (ResolveInfo info : matches) {
                    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                        intent.setPackage(info.activityInfo.packageName);
                        facebookAppFound = true;
                        break;
                    }
                }
                if(!facebookAppFound) {
                    String url = "https://www.facebook.com";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                }
                startActivity(intent);

                return true;
            } else if (item.getItemId() == R.id.no) {
                return true;
            } else {
                return false;
            }
        }
        else if(ab.equals("Whatsapp"))
        {
            String contact = "+92 3034049689"; // use country code with your phone number
            String url = "https://api.whatsapp.com/send?phone=" + contact;
            try {
                PackageManager pm = getPackageManager();
                pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(getApplicationContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

        return true;
    }
}
