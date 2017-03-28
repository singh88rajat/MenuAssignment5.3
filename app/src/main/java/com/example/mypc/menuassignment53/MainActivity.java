package com.example.mypc.menuassignment53;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypc.menuassignment53.Adapter.CustomAdapterView;
import com.example.mypc.menuassignment53.CustomHandler.CustomHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView list;
    String name[]=new String[]{
            "Name 1","Name2", "Name 3", "Name 4", "Name 5", "Name 6" } ;
    String phone[] = new String []{"9988998871","9988998872","9988998873","9988998874","9988998875","9988998876"};

    ArrayList<CustomHandler> model= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        list = (ListView) findViewById(R.id.list);

        for(int i=0; i<name.length; i++){
            CustomHandler handler= new CustomHandler();
            handler.setName(name[i]);
            handler.setPhonenumber(phone[i]);
            model.add(handler);
        }
        CustomAdapterView adapter= new CustomAdapterView(this, model);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello From Mukesh");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone[0]));
            startActivity(intent);
        } catch (Exception e) {

        }

    }
}
