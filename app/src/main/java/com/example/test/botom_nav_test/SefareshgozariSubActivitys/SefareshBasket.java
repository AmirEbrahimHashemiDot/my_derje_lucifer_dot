package com.example.test.botom_nav_test.SefareshgozariSubActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.BasketProAdapter;
import com.example.test.botom_nav_test.Model.BasketProModel;
import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SefareshBasket extends AppCompatActivity {

    //API URL
    public static String BASE_URL = "http://derje.ir/ShoppingCart/AddToCartList?listId=20410&listId=20479";
    public static String sec_static = "http://derje.ir/ShoppingCart/AddToCartList?";
    public static String sec_param_name = "listId=";
    public static String sec_and = "&";
    public static String suffixLink = "";
    //public static String final_sec = "";
    public static String longSuffix = "";
    //public static String backsuff = "";
    public static String lastFinalLink = "";

    //Variable
    public static ArrayList<BasketProModel> basketArrayList = new ArrayList<BasketProModel>();
    public static BasketProAdapter basketProAdapter;
    //public static String send_pro_id_api_url = "derje.ir/ShoppingCart/AddToCartList?listId=20410&listId=20479";
    //public static String send_pro_id_api_url_1 = "derje.ir/ShoppingCart/AddToCartList?listId=";
    //public static String send_pro_id_api_url_2 = "&listId=";

    public static Context context;

    //Widget
    public Button btn_karid, btn_goto_Sefareshgozary_from_basket;
    public ListView final_selected_pro_list;
    public ExampleItem_ProModel exampleModel_pro = new ExampleItem_ProModel();
    //public ArrayList<Integer> finalList;
    //public ArrayAdapter<Integer> IDsAdapter;

    public static Context getAppContext() {
        return SefareshBasket.context;
    }

    public static void  removeBasketItemByPosition(int pos) {
        basketArrayList.remove(pos);
        basketProAdapter.notifyDataSetChanged();

    }

    public static void sendProIDs() { //Send IDs and get result
        StringRequest stringRequest = new StringRequest(Request.Method.GET, lastFinalLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "کالا ثبت شد", Toast.LENGTH_SHORT).show();
                Log.i("response__amir", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error in send IDs", Toast.LENGTH_SHORT).show();
                Log.i("id_tag_e", error.toString());
                //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        /*{
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                //params.put("listId", selectedID);
                return params;
            }
        }*/
        RequestQueue requestQueue = Volley.newRequestQueue(SefareshBasket.getAppContext());
        requestQueue.add(stringRequest);

        Log.i("link_", lastFinalLink);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefaresh_basket);
        setUPViews_Events();
        //basketArrayList.add(new BasketProModel(exampleModel_pro.get$id(), exampleModel_pro.getProID(), exampleModel_pro.getProductName(), exampleModel_pro.getSupplier(), exampleModel_pro.getImage(), exampleModel_pro.getPrice()));
        basketProAdapter = new BasketProAdapter(SefareshBasket.this, R.layout.basket_pro_item, basketArrayList);
        final_selected_pro_list.setAdapter(basketProAdapter);
        basketProAdapter.notifyDataSetChanged();
        /*finalList = new ArrayList<Integer>(ExampleAdapter_Ryv.setSelectedArrayList());
        IDsAdapter = new ArrayAdapter<Integer>(SefareshBasket.this, android.R.layout.simple_list_item_1, finalList);
        final_selected_pro_list.setAdapter(IDsAdapter);*/ //Old ListView
    }

    private void getIntents() {

    }

    private void setUPViews_Events() {
        SefareshBasket.context = getApplicationContext();
        final_selected_pro_list = (ListView) findViewById(R.id.final_selected_pro_list);
        btn_karid = (Button) findViewById(R.id.btn_karid);
        btn_goto_Sefareshgozary_from_basket = (Button) findViewById(R.id.btn_goto_Sefareshgozary_from_basket);
        btn_goto_Sefareshgozary_from_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(SefareshBasket.this, KaridMiveActivity.class);
                startActivity(intent);
                finish();*/
                onBackPressed();
            }
        });

        btn_karid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*for (int i = 0; i < basketArrayList.size(); i++) {
                    //Log.i("AmirArrayTag", basketArrayList.get(i).toString());
                    int sendProID = basketArrayList.get(i).proID;
                    String SsendProID = Integer.toString(sendProID);
                    Log.i("AmirArrayTag", SsendProID);
                    sendProIDs(sendProID);
                }*/

                for (int i = 0; i < basketArrayList.size(); i++) {
                    //ایدی پوزیشن i ام رو داریم
                    int sendProID = basketArrayList.get(i).proID;
                    String SsendProID = Integer.toString(sendProID);
                    Log.i("AmirArrayTag", SsendProID);

                    if (i != basketArrayList.size() - 1) { // -1 در این جا به این دلیل است که در صورت رسیدن به خانه آخر آرایه نیاز به اضافه کردن & بعد از ایدی در لینک نیست
                        suffixLink = sec_param_name + sendProID + sec_and;
                    } else {
                        suffixLink = sec_param_name + sendProID;
                    }
                    longSuffix = longSuffix + suffixLink;
                    /*if (i != basketArrayList.size() - 1) {
                        final_sec = sec_static + sec_param_name + SsendProID + sec_and;
                    } else {
                        final_sec = sec_static + sec_param_name + SsendProID;
                    }*/ // soran
                    /*if (i == basketArrayList.size() - 1) {
                        final_sec = sec_static + sec_param_name + SsendProID;
                    } else {
                        final_sec = sec_static + sec_param_name + SsendProID + sec_and;
                    }*/ // me
                }
                lastFinalLink = sec_static + longSuffix;
                Log.i("last_link_log", lastFinalLink);
                sendProIDs();
                Intent intent = new Intent(SefareshBasket.this, WebBasketActivity.class);
                intent.putExtra("final_link_show", lastFinalLink);
                startActivity(intent);
                finish();
            }
        });
    }
    /*@Override
    public void onBackPressed() {
        switch (R.id.btn_goto_Sefareshgozary_from_basket) {
            case R.id.btn_goto_Sefareshgozary_from_basket:
                super.onBackPressed();
                //Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return;
    }*/
}