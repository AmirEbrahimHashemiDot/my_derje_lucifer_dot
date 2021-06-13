package com.example.test.botom_nav_test.Baskets.TanorestanBasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.Adapter.TanorestanBasketAdapter.TanorestanBasketAdapter;
import com.example.test.botom_nav_test.Model.BasketProModel;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.TanorestanBasketModel.TanorestanBasketModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.ValueHolder.Common;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public class TanorestanBasket extends AppCompatActivity {

    public static ArrayList<TanorestanBasketModel> tanorestanBasketModelArrayList = new ArrayList<TanorestanBasketModel>();
    public static TanorestanBasketAdapter tanorestanBasketAdapter;
    public static TextView txt_view_basket_array_count;
    public static int public_price_sum = 0;
    public String name;
    public String desc;
    public String price;
    public String count;
    public String Image;
    //public static ArrayList<BasketProModel> basketArrayList = new ArrayList<BasketProModel>();
    public Button btn_gobackto_home_from_tanor_basket, btn_karid;
    public RecyclerView tanorestan_basket_rcv;
    public TanorestanBasketModel tanorestanBasketModel;
    public Context mcontext;
    public static String public_tmp_string_price;

    /*public ArrayList<TanorestanBasketModel> getMyList() {
        return tanorestanBasketModelArrayList;
    }*/

    public static void clearBasketItems() {
        tanorestanBasketModelArrayList.clear();
        tanorestanBasketModelArrayList = new ArrayList<TanorestanBasketModel>();
        //tanorestanBasketModelArrayList.removeAll(tanorestanBasketModelArrayList);
        //tanorestanBasketModelArrayList.notifyAll();
    }

    public static void removeBasketItemByPosition(int pos) {
        tanorestanBasketModelArrayList.remove(pos);
        tanorestanBasketAdapter.notifyDataSetChanged();
    }

    public static void getPriceSum() {
        for (int i = 0; i <= tanorestanBasketModelArrayList.size() - 1; i++) {
            String price_sum = TanorestanBasket.tanorestanBasketModelArrayList.get(i).getPrice();
            int price_sum_int = Integer.parseInt(price_sum);
            public_price_sum += price_sum_int;
            String print_price_sum = String.valueOf(public_price_sum);
            txt_view_basket_array_count.setText(print_price_sum);
        }
    }

    public static void refreshPriceCount(int pos) {
        String price_sum = TanorestanBasket.tanorestanBasketModelArrayList.get(pos).getPrice();
        int price_sum_int = Integer.parseInt(price_sum);
        public_price_sum = public_price_sum - price_sum_int;
    }

    public static void refPriceWhenAdd(String price) {
        int tmp_int_price = Integer.parseInt(price);
        //public_price_sum = public_price_sum + tmp_int_price;
        public_tmp_string_price = String.valueOf(public_price_sum);
        //txt_view_basket_array_count.setText(tmp_string_price);
        //return tmp_string_price;
    }

    public static void refreshBasketCount() {
        int size = tanorestanBasketModelArrayList.size();
        String size_s = Integer.toString(size);
        txt_view_basket_array_count.setText(size_s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanorestan_basket);

        setUpViews();
        Log.i("ar22", tanorestanBasketModelArrayList.toString());
        /*try {
            getIntentFromDetale();
        } catch (Exception e) {
            //Toast.makeText(TanorestanBasket.this, "main inrent error : " + e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            Log.i("e_log2", e.toString());
        }*/
        setUpRcvAdapter();
        chekPriceVal();
        //txt_view_basket_array_count.setText(public_tmp_string_price);
        //refreshBasketCount();
        //getPriceSum();

        /*btn_karid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tanorestanBasketModelArrayList.size() < 0) {
                    Toast.makeText(TanorestanBasket.this, "سبد خرید خالیست.\nیک محصول انتخاب کنید.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(TanorestanBasket.this, TanorestanGetUserDataActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });*/
        //tanorestanBasketAdapter.notifyDataSetChanged();
        /*for (int i = 0; i <= tanorestanBasketModelArrayList.size(); i++) {
            Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
        }*/
    }

    public static void chekPriceVal() {
        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(Common.showCurrentPrice());
        txt_view_basket_array_count.setText("قیمت کل : " + formattedNumber + " تومان");

        //txt_view_basket_array_count.setText("قیمت کل : " + String.valueOf(Common.showCurrentPrice()));
        /*NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(String.valueOf(Common.showCurrentPrice()));
        txt_view_basket_array_count.setText("قیمت کل : " + formattedNumber);*/
    }

    private void setUpRcvAdapter() {
        /*Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(0).getCount(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(0).getImage(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(0).getName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(0).getPrice(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, tanorestanBasketModelArrayList.get(0).getSupplier(), Toast.LENGTH_SHORT).show();*/
        Log.i("ar221", tanorestanBasketModelArrayList.toString());
        tanorestanBasketAdapter = new TanorestanBasketAdapter(TanorestanBasket.this, tanorestanBasketModelArrayList);
        tanorestan_basket_rcv.setAdapter(tanorestanBasketAdapter);
        tanorestan_basket_rcv.setLayoutManager(new GridLayoutManager(TanorestanBasket.this, 1));
        tanorestanBasketAdapter.notifyDataSetChanged();
    }

    private void getIntentFromDetale() {
        try {
            //name = Objects.requireNonNull(getIntent().getExtras()).getString("pro_name");
            name = getIntent().getExtras().getString("pro_name");
            desc = getIntent().getExtras().getString("pro_desc");
            price = getIntent().getExtras().getString("pro_price");
            count = getIntent().getExtras().getString("pro_count");
            Image = getIntent().getExtras().getString("pro_image");

            Log.i("b_name", name);
            Log.i("b_desc", desc);
            Log.i("b_price", price);
            Log.i("b_count", count);
            Log.i("b_image", Image);

        } catch (Exception e) {
            e.printStackTrace();
            //Toast.makeText(TanorestanBasket.this, "intent error : " + e, Toast.LENGTH_SHORT).show();
        }
        /*for (int i = 0; i <= tanorestanBasketModelArrayList.size(); i++) {
            tanorestanBasketModel.setName(name);
        }*/
        tanorestanBasketModelArrayList.add(new TanorestanBasketModel(name, desc, price, count, Image));
        //tanorestanBasketModelArrayList.notify();
        //tanorestanBasketModelArrayList.notifyAll();
        if (tanorestanBasketModelArrayList != null) {
            Toast.makeText(TanorestanBasket.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(TanorestanBasket.this, "ارایه خالی است", Toast.LENGTH_SHORT).show();
        }
        /*String a = tanorestanBasketModelArrayList.get(0).getSupplier();
        String b = tanorestanBasketModelArrayList.get(0).getPrice();
        String c = tanorestanBasketModelArrayList.get(0).getName();
        String d = tanorestanBasketModelArrayList.get(0).getImage();
        String e = tanorestanBasketModelArrayList.get(0).getCount();

        Toast.makeText(TanorestanBasket.this, "sup = " + a.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, "price = " + b.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, "name = " + c.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, "image = " + d.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(TanorestanBasket.this, "count = " + e.toString(), Toast.LENGTH_SHORT).show();*/
    }

    public void setUpViews() {
        txt_view_basket_array_count = (TextView) findViewById(R.id.txt_view_basket_array_count);

        btn_karid = (Button) findViewById(R.id.btn_karid);
        //tanorestanBasketModelArrayList = new ArrayList<TanorestanBasketModel>();
        tanorestanBasketModel = new TanorestanBasketModel();
        tanorestanBasketAdapter = new TanorestanBasketAdapter();
        btn_gobackto_home_from_tanor_basket = (Button) findViewById(R.id.btn_gobackto_home_from_tanor_basket);
        tanorestan_basket_rcv = (RecyclerView) findViewById(R.id.tanorestan_basket_rcv);

        btn_gobackto_home_from_tanor_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_karid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tanorestanBasketModelArrayList.size() <= 0) {
                    Toast.makeText(TanorestanBasket.this, "سبد خرید خالیست.\nیک محصول انتخاب کنید.", Toast.LENGTH_SHORT).show();
                } else {
                    String name = tanorestanBasketModelArrayList.get(0).getName();
                    int i = tanorestanBasketModelArrayList.size();
                    String s = String.valueOf(i);
                    Log.i("b_a_log", name);
                    Intent intent = new Intent(TanorestanBasket.this, TanorestanGetUserDataActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        /*tanorestanBasketModel = new TanorestanBasketModel();
        tanorestanBasketAdapter = new TanorestanBasketAdapter(TanorestanBasket.this, tanorestanBasketModelArrayList);
        tanorestan_basket_rcv.setAdapter(tanorestanBasketAdapter);*/
    }
}