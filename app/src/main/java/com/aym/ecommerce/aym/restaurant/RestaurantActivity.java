package com.aym.ecommerce.aym.restaurant;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.aym.ecommerce.aym.MyApp;
import com.aym.ecommerce.aym.R;
import com.aym.ecommerce.aym.weather.Cons;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestaurantActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<CollectionClass> arrayList = new ArrayList();
    ADT adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        JSONObject jobj = new JSONObject();

        lv = findViewById(R.id.lv);
        adt = new ADT(RestaurantActivity.this, arrayList);
        lv.setAdapter(adt);


        //curl -X GET --header "Accept: application/json" --header "user-key: cd2c7e1e7579cd2537f2bd90aa1ae88a" "https://developers.zomato.com/api/v2.1/collections?city_id=51"

        arrayList.clear();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST, "https://developers.zomato.com/api/v2.1/collections?city_id=51",
                jobj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        //call successful
                        Log.d("000999", "==== " + jsonObject);
                        Log.d("000990", "==== " + Cons.restaurantKey);

                        Toast.makeText(RestaurantActivity.this, "onResponse", Toast.LENGTH_SHORT).show();

                        try {
                            CollectionClass collectionClass;
                            JSONArray jsonArray = jsonObject.getJSONArray("collections");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                try {
                                    collectionClass = new CollectionClass(jsonArray.getJSONObject(i).getJSONObject("collection").getInt("collection_id"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getInt("res_count"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getString("image_url"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getString("url"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getString("title"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getString("description"),
                                            jsonArray.getJSONObject(i).getJSONObject("collection").getString("share_url"));
                                    arrayList.add(collectionClass);

                                    Log.d("000999", "==--== "+i);

                                }catch (Exception e){

                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                        adt.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) { //error occur
                        Log.d("000999", "==== " + volleyError.getMessage().toString());
                        Toast.makeText(RestaurantActivity.this, "onErrorResponse", Toast.LENGTH_SHORT).show();
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Accept", "application/json");
                params.put("Accept-Encoding", "utf-8");
                params.put("user-key", "cd2c7e1e7579cd2537f2bd90aa1ae88a");
                return params;
            }
        };
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApp.getInstance().addToRequestQueue(jsonRequest);

    }
}
