package com.example.user.resturantfoodmenu.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.user.resturantfoodmenu.R;

/**
 * Created by User on 3/9/2016.
 */
public class Listviewholder {
    ImageView image;
    TextView name,numbermenu,price;


    public Listviewholder(View v)
    {
        super();
        image=(ImageView)v.findViewById(R.id.img);
        name= (TextView) v.findViewById(R.id.nametext);
        numbermenu= (TextView) v.findViewById(R.id.numbertext);
        price= (TextView) v.findViewById(R.id.pricetext);

    }
}
