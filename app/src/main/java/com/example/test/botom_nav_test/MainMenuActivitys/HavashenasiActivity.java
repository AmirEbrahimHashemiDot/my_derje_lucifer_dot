package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HavashenasiActivity extends AppCompatActivity {

    CardView card_view_hava;
    ImageView weater_icon;
    TextView temperature_value, my_date, my_city, my_description;
    Button btn_goto_havashenasi_from_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_havashenasi);
        setUpViewsEvents();
        findWeather();
    }

    private void findWeather() {
        String weatherUrlAPI = "https://api.openweathermap.org/data/2.5/weather?q=Alborz,Iran&appid=5cbeef79f8abe8de9fe97971e65135a2&units=Imperial";
        //String weatherUrlAPI = "https://api.openweathermap.org/data/2.5/weather?q=Tehran,Iran&appid=5cbeef79f8abe8de9fe97971e65135a2&units=Imperial";
        //String weatherUrlAPI = "https://api.openweathermap.org/data/2.5/weather?q=Alborz,Iran&appid=5cbeef79f8abe8de9fe97971e65135a2&units=Khor";
        //String weatherUrlAPI = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=5cbeef79f8abe8de9fe97971e65135a2&units=Imperial";
        //String weatherUrlAPI = "https://api.openweathermap.org/data/2.5/weather?q=Geneva,Switzerland&appid=5cbeef79f8abe8de9fe97971e65135a2&units=Imperial";
        JsonObjectRequest weatherJsonObject = new JsonObjectRequest(Request.Method.GET, weatherUrlAPI, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");

                    //temperature_value.setText(temp);
                    my_city.setText("Khor - "+city);
                    my_description.setText(description);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE MM-dd");
                    String formatted_date = sdf.format(calendar.getTime());

                    my_date.setText(formatted_date);

                    double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) / 1.8000;
                    centi = Math.round(centi);
                    int i = (int) centi;
                    temperature_value.setText(String.valueOf(i));
                    //temperature_value.setText(temp);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HavashenasiActivity.this, "Error in Connecting to Weather TestingAPI", Toast.LENGTH_SHORT).show();
                //Toast.makeText(HavashenasiActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.i("weather_log" ,error.toString());
            }
        });
        //weatherJsonObject.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(weatherJsonObject);
    }

    private void setUpViewsEvents() {

        btn_goto_havashenasi_from_home = (Button) findViewById(R.id.btn_goto_havashenasi_from_home);
        btn_goto_havashenasi_from_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HavashenasiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        card_view_hava = (CardView) findViewById(R.id.card_view_hava);
        card_view_hava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HavashenasiActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                findWeather();
            }
        });

        weater_icon = (ImageView) findViewById(R.id.weater_icon);

        temperature_value = (TextView) findViewById(R.id.temperature_value);

        my_date = (TextView) findViewById(R.id.date);

        my_city = (TextView) findViewById(R.id.city);

        my_description = (TextView) findViewById(R.id.description);
    }
}
