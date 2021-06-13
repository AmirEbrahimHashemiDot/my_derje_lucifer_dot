package com.example.test.botom_nav_test.Baskets.TanorestanBasket;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.MainMenuActivitys.MahsolatDehkadeActivity;
import com.example.test.botom_nav_test.Model.TanorestanBasketModel.TanorestanBasketModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.ValueHolder.Common;

import java.util.ArrayList;

public class TanorestanGetUserDataActivity extends AppCompatActivity {

    public static String user_name;
    public static String user_fam;
    public static String user_phone;
    public static String user_address;
    public static String user_products_name_and_count_list = "";
    public static String user_type = "3";
    public static AlertDialog.Builder successDialog;
    public static Dialog dialog_load;
    //api extras
    public String first_sec_url = "http://171.22.27.135:5051/api/Message/CreateWithGet?";
    public String and_sec = "&";
    public String firstname_sec = "FirstName=";
    public String lastname_sec = "LastName=";
    public String message_sec = "Message=";
    public String phone_sec = "PhoneNumber=";
    public String address_sec = "Address=";
    /*public String final_url = first_sec_url + firstname_sec + name + and_sec + lastname_sec + fam + and_sec + message_sec + message + and_sec
            + phone_sec + phone + and_sec + type_sec + type_sec_pish;*/
    //?FirstName=amirebrahim&LastName=hashemi&Message=besyarkhob&PhoneNumber=09368515148&Type=2
    public String type_sec = "Type=";
    public String type_sec_pish = "1";
    public String type_sec_entq = "2";
    public String final_url = "";
    //get user products list array
    //public ArrayList<TanorestanBasketModel> productList = new ArrayList<TanorestanBasketModel>();
    //temp string
    public String tmp;
    public Button btn_send_data, btn_gobackto_home_from_tanor_get_user_data_tanor;
    public EditText edt_user_name, edt_user_fam, edt_user_phone, tanor_edtaddress;
    //public static String public_response = "";

    //@RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanorestan_get_user_data);


        setUpViews();

        //getUserDataText();

        //generateUserProList();

        //sendDataToApi();

        sendButtonClicked();
    }

    private void sendButtonClicked() {
        btn_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (user_name.length() == 0 && user_fam.length() == 0 && user_phone.length() == 0) {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "مقادیر پُر است.", Toast.LENGTH_SHORT).show();
                    try {
                        getUserDataText();
                        generateUserProList();
                        generateUrl();
                        sendDataToApi();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(TanorestanGetUserDataActivity.this, "send data method error : " + e, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "مقدایر را کامل وارد کنید.", Toast.LENGTH_SHORT).show();
                }*/

                dialog_load = new Dialog(TanorestanGetUserDataActivity.this);
                final View itemView = LayoutInflater.from(TanorestanGetUserDataActivity.this).inflate(R.layout.sefareshgozari_loading, null);
                dialog_load.setContentView(itemView);
                dialog_load.create();
                dialog_load.show();

                getUserDataText();
                generateUserProList();
                generateUrl();
                sendDataToApi();

                Log.i("last_link_log", final_url);
                /*if (public_response.equals("1")) {
                    successDialog();
                } else {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "ثبت سفارش با مشکل روبه رو شد.\nبا پشتیبانی تماس بگیرید.", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    public void successDialog() {
        Log.i("dialog__", "dialog in true");
        successDialog = new AlertDialog.Builder((TanorestanGetUserDataActivity.this))
                /*
                .setTitle("Remove Favorite")
                .setMessage("Are You Sure?")
                * */ //English
                .setTitle("سفارش با موفقیت ثبت شد")
                .setMessage("سفارش شما با موفقیت ثبت شد.\nبا شما تماس خواهیم گرفت.\nممنون از خرید شما :)")
                .setIcon(android.R.drawable.presence_online)
                .setCancelable(false);
        successDialog.setPositiveButton("باشه", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TanorestanGetUserDataActivity.this, "سفارش شما با موفقیت ثبت شد.", Toast.LENGTH_SHORT).show();
                //TanorestanBasket.tanorestanBasketModelArrayList.clear();
                Intent intent = new Intent(TanorestanGetUserDataActivity.this, MahsolatDehkadeActivity.class);
                //Toast.makeText(TanorestanGetUserDataActivity.this, "Array : " + TanorestanBasket.tanorestanBasketModelArrayList, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                dialog.cancel();
                dialog.dismiss();
            }
        }).setNegativeButton("هِدایت به پَنِل", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TanorestanGetUserDataActivity.this, "پنل در دسترس نیست.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TanorestanGetUserDataActivity.this, MahsolatDehkadeActivity.class);
                startActivity(intent);
                finish();
                //TanorestanBasket.tanorestanBasketModelArrayList.clear();
                dialog.cancel();
                dialog.dismiss();
            }
        });
        successDialog.show();
    }

    private void generateUserProList() {

        int count = TanorestanBasket.tanorestanBasketModelArrayList.size();
        String count_s = Integer.toString(count);
        //Toast.makeText(TanorestanGetUserDataActivity.this, "size : " + count_s, Toast.LENGTH_SHORT).show();

        for (int i = 0; i <= TanorestanBasket.tanorestanBasketModelArrayList.size() - 1; i++) {
            String a = TanorestanBasket.tanorestanBasketModelArrayList.get(i).getName();
            String b = TanorestanBasket.tanorestanBasketModelArrayList.get(i).getCount();
            String c = TanorestanBasket.tanorestanBasketModelArrayList.get(i).getPrice();
            //tmp =/* "\n" + */"Name : " + a + "\n" + "Count : " + b + "\n";
            //tmp = "نام کالا : " + a + " - " + "تعداد : " + b + " - " + "قیمت : " + c + "$" + " || ";
            tmp = a + "-" + b + "-" + c + "$" + "|";
            user_products_name_and_count_list = user_products_name_and_count_list + tmp;
            //user_products_name_and_count_list = a + "\n" + b;
        }

        Log.i("a2log", user_products_name_and_count_list);

        /*String a = TanorestanBasket.tanorestanBasketModelArrayList.get(0).getPrice();
        Log.i("a_log",a);*/
        /*String a = TanorestanBasket.tanorestanBasketModelArrayList.get(0).getName();
        String b = TanorestanBasket.tanorestanBasketModelArrayList.get(0).getCount();
        Log.i("a_log",a);
        Log.i("a_log",b);

        String c = TanorestanBasket.tanorestanBasketModelArrayList.get(1).getName();
        String d = TanorestanBasket.tanorestanBasketModelArrayList.get(1).getCount();
        Log.i("a_log",c);
        Log.i("a_log",d);*/
    }

    private void sendDataToApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, final_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Toast.makeText(TanorestanGetUserDataActivity.this, "res is : " + response, Toast.LENGTH_SHORT).show();
                //public_response = response;
                Log.i("final_link", final_url);
                Log.i("response", response);
                if (response.isEmpty()) {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "response is empty", Toast.LENGTH_SHORT).show();
                }

                if (response.equals("1")) {
                    //TanorestanBasket.tanorestanBasketModelArrayList.removeAll(TanorestanBasket.tanorestanBasketModelArrayList);
                    TanorestanBasket.clearBasketItems();
                    user_products_name_and_count_list = "";
                    tmp = "";
                    Common.basket_price_sum_holder = 0;
                    dialog_load.cancel();
                    dialog_load.dismiss();
                    successDialog();
                } else {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "ثبت سفارش با مشکل روبه رو شد.\nبا پشتیبانی تماس بگیرید.", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("amir_v_e", "error in connection : " + error.getMessage());
                Toast.makeText(TanorestanGetUserDataActivity.this, "server error > " + error.getMessage(), Toast.LENGTH_SHORT).show();

                try {
                    sendDataToApi();
                } catch (Exception e) {
                    Toast.makeText(TanorestanGetUserDataActivity.this, "cant resend request. \n با پشتیبانی تماس بگیرید", Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(MainActivity.this, "got error", Toast.LENGTH_SHORT).show();
            }
        }) /*{
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                params.put("FirstName", "علی");
                params.put("LastName", "هاشمی");
                params.put("Message", "سلام");
                params.put("PhoneNumber", "09368515148");
                params.put("Type", "2");

                *//*params.put("FirstName", name);
                params.put("LastName", fam);
                params.put("Message", message);
                params.put("PhoneNumber", phone);
                params.put("Type", "2");*//*

                try {
                    Log.i("params", params.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("error_print_param", e.getMessage());
                }

                return params;
            }
        }*/;
        RequestQueue requestQueue = Volley.newRequestQueue(TanorestanGetUserDataActivity.this);
        requestQueue.add(stringRequest);
        Log.i("final_link", final_url);
        //Log.i("final_link", api_uri);
    }

    private void generateUrl() {
        final_url = first_sec_url +
                firstname_sec + user_name + and_sec +
                lastname_sec + user_fam + and_sec +
                message_sec + user_products_name_and_count_list + and_sec +
                phone_sec + user_phone + and_sec +
                address_sec + user_address + and_sec +
                type_sec + user_type;
        Log.i("final_link2", final_url);
    }

    private void getUserDataText() {
        user_name = edt_user_name.getText().toString();
        user_fam = edt_user_fam.getText().toString();
        user_phone = edt_user_phone.getText().toString();
        user_address = tanor_edtaddress.getText().toString();
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    private void setUpViews() {
        tanor_edtaddress = (EditText) findViewById(R.id.tanor_edtaddress);
        btn_send_data = (Button) findViewById(R.id.btn_send);
        btn_gobackto_home_from_tanor_get_user_data_tanor = (Button) findViewById(R.id.btn_gobackto_home_from_tanor_get_user_data_tanor);
        edt_user_name = (EditText) findViewById(R.id.tanor_edtName);
        edt_user_fam = (EditText) findViewById(R.id.tanor_edtfam);
        edt_user_phone = (EditText) findViewById(R.id.tanor_edtphone);
        btn_gobackto_home_from_tanor_get_user_data_tanor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TanorestanGetUserDataActivity.this, TanorestanBasket.class);
                startActivity(intent);
                finish();
            }
        });


        //edt_user_name.setFocusedByDefault(true);
    }
}