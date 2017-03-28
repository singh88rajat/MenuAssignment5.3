package com.example.mypc.menuassignment53;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypc.menuassignment53.Adapter.CustomAdapterView;
import com.example.mypc.menuassignment53.CustomHandler.CustomHandler;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView list;
    private static final int MENU_ID_01 = 100;
    private static final int MENU_ID_02 = 101;
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

        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Action");
        menu.add(0, MENU_ID_01, 2, "Call");//groupId, itemId, order, title
        menu.add(0, MENU_ID_02, 1, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==MENU_ID_01 && item.getGroupId()==0){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
           /* Toast.makeText(getApplicationContext(),"Clicked on " +item.getGroupId()+"..."+item.getItemId(),Toast.LENGTH_LONG).show();*/
        }
        else if(item.getItemId()==MENU_ID_02 && item.getGroupId()==0){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(intent);
          /*  Toast.makeText(getApplicationContext(),"Clicked on " +item.getGroupId()+"..."+item.getItemId(),Toast.LENGTH_LONG).show();*/
        }
        else{
            return false;
        }
        return true;
    }
}
