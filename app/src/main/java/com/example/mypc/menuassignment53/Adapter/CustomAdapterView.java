package com.example.mypc.menuassignment53.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mypc.menuassignment53.CustomHandler.CustomHandler;
import com.example.mypc.menuassignment53.R;

import java.util.ArrayList;

/**
 * Created by my pc on 3/27/2017.
 */

public class CustomAdapterView extends BaseAdapter {

    Context context;
    ArrayList<CustomHandler> data;
    LayoutInflater inflater;


    public CustomAdapterView(Context context, ArrayList<CustomHandler> data){
        this.context=context;
        this.data= data;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView= inflater.inflate(R.layout.custom_row, parent, false);
            holder= new ViewHolder();

            holder.name= (TextView)convertView.findViewById(R.id.name);
            holder.phonenumber= (TextView)convertView.findViewById(R.id.phonenumber);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }

        holder.name.setText(data.get(position).getName());
        holder.phonenumber.setText(data.get(position).getPhonenumber());
        return convertView;
    }

    public class ViewHolder{
        /*   TextView view;*/
        TextView name, phonenumber;
    }
}