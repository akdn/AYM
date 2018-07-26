package com.aym.ecommerce.aym.weather;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by mani on 26/07/2018.
 */

public class Cons {

    public static String restaurantKey = "cd2c7e1e7579cd2537f2bd90aa1ae88a";
    public static String weatherKey = "addf62da20021532969c5859d2969d6f";

    SharedPreferences prefs;

    public Cons(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }
    String getCity(){
        return prefs.getString("city", "Islamabad, PK");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }



}
