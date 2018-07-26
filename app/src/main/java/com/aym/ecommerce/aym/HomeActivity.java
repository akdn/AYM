package com.aym.ecommerce.aym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aym.ecommerce.aym.restaurant.RestaurantActivity;
import com.aym.ecommerce.aym.weather.WeatherActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button btWeather = findViewById(R.id.btWeather);
        Button btRestaurant = findViewById(R.id.btRestaurant);



        btWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, WeatherActivity.class));
            }
        });

        btRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, RestaurantActivity.class));
            }
        });



    }

}
