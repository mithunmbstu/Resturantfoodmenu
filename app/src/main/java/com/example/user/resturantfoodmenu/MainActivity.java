package com.example.user.resturantfoodmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.resturantfoodmenu.Adapter.Listrowiteam;
import com.example.user.resturantfoodmenu.Adapter.Listviewadapter;
import com.example.user.resturantfoodmenu.Volley.AppConfig;
import com.example.user.resturantfoodmenu.Volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      ListView listView;

       public List<String> image = new ArrayList<String>();
      public List<String> number = new ArrayList<String>();
       public List<String> name = new ArrayList<String>();
       public List <String> price = new ArrayList<String>();
    Context context ;
    Listviewadapter listviewadapter;


    private static final String TAG=MainActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listmenu);
        context = getApplicationContext();
        showall();



    }

    private void showall() {

        String tag_array_req = "req_show";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AppConfig.show, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String nam, img, menunumber, pricetag;
                try {
                    JSONArray array = new JSONArray(response);
                    for(int i=0; i<array.length(); i++)
                    {
                        JSONObject jobj1 = array.getJSONObject(i);
                        img = jobj1.getString("image");
                        nam = jobj1.getString("name");
                        menunumber = jobj1.getString("menunum");
                        pricetag=jobj1.getString("price");


                        name.add(nam);
                        image.add(img);
                        number.add(menunumber);
                        price.add(pricetag);
                    }






                    List<Listrowiteam> eachItem = new ArrayList<Listrowiteam>();

                    for (int i = 0; i < name.size(); i++)
                    {
                        eachItem.add(new Listrowiteam(image.get(i), name.get(i), number.get(i),price.get(i)));
                    }

                    listviewadapter = new Listviewadapter(context, eachItem);
                    listView.setAdapter(listviewadapter);




        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}, new Response.ErrorListener()
        {
@Override
public void onErrorResponse(VolleyError error)
        {
        Log.e(TAG, "Showing Error: " + error.getMessage());
        Toast.makeText(getApplicationContext(),
                error.getMessage(), Toast.LENGTH_LONG).show();
        }
        });
        AppController.getInstance().addToRequestQueue(stringRequest, tag_array_req);
        }
        }