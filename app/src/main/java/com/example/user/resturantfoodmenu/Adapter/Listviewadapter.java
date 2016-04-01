package com.example.user.resturantfoodmenu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.user.resturantfoodmenu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 3/31/2016.
 */
public class Listviewadapter extends BaseAdapter {

    Context context;
    List<Listrowiteam>arraylist;


    public  Listviewadapter(Context context,  List<Listrowiteam>arraylist)
    {
        this.context=context;
        this.arraylist=arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }


    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View r=convertView;
        Listviewholder listviewholder=null;
        if (r==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            r=inflater.inflate(R.layout.list_single,parent,false);
            listviewholder=new Listviewholder(r);
            r.setTag(listviewholder);
        }
        else
        {
            listviewholder= (Listviewholder) r.getTag();
        }


     Listrowiteam listrowiteam=arraylist.get(position);

        Picasso.with(context)
                .load(listrowiteam.getImage())
                .into(listviewholder.image);

        listviewholder.name.setText(listrowiteam.getName() + "");
        listviewholder.numbermenu.setText(listrowiteam.getMenuno() + "");
        listviewholder.price.setText(listrowiteam.getPrice()+"");
        return r;
    }
}
