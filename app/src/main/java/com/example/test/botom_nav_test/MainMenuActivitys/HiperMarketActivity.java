package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.ExampleAdapter_ProRyv;
import com.example.test.botom_nav_test.Adapter.ExampleAdapter_Ryv;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.Model.CategoryModel;
import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.Model.ExampleItem_model;
import com.example.test.botom_nav_test.Model.FavProModel;
import com.example.test.botom_nav_test.Model.UserInfo;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class HiperMarketActivity extends AppCompatActivity implements ExampleAdapter_Ryv.onItemClickListener {

    public static final ArrayList<Integer> all_selected_faverit = new ArrayList<Integer>();
    public static ArrayList<FavProModel> favArrayList;
    public ExampleItem_model exampleModel_cat = new ExampleItem_model();
    public ExampleItem_ProModel exampleModel_pro = new ExampleItem_ProModel();
    public ExampleAdapter_Ryv mExampleAdapter_Ryv;//آداپتور  cat RYV
    public ExampleAdapter_ProRyv mExampleAdapter_ProRyv;//آداپتور RYV PRO
    public ArrayList<ExampleItem_model> mExampleList;//آریه ای که لیست مواردcat RYV را در خود نگه میدارد.
    public ArrayList<ExampleItem_ProModel> mExampleList_Pro;//آریه ای که لیست مواردpro RYV را در خود نگه میدارد.
    public CategoryModel category = new CategoryModel();
    public int public_ryv_pro_position;
    public Dialog dialog_load;
    Button btn_goto_homeactivity_from_hiper;
    Button btn_goto_homeactivity;
    List<UserInfo> userInfoslist;
    String recy_cat_api_url = "http://171.22.27.135:9099/api/CateGory/GetCateory";
    String recy_pro_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=";
    /*String recy_pro_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=10040";
    String recy_pro_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?";
    String url = "http://171.22.27.135:9096/api/Person/GetInfoUser";*/  //URL
    String public_recy_pro_api_url;
    ImageView btn_takmil_karid;
    TextView txt_sabad_karid_title;
    TextView txt_test_var;
    Thread thread;
    Handler handler;
    String ID2_;
    String serverID;
    Boolean flag_for_click = false;
    Boolean adapterIsSet_flag = false;
    //TextView txt_pro_title;
    //ImageView img_arrow_pro;
    private RecyclerView ryscrview_category;
    private RecyclerView ryscrview_product;

    public static ArrayList<FavProModel> returnAdapterHolderArray() {
        return favArrayList;
    }

    public static boolean addFavID(Integer ID) {
        all_selected_faverit.add(ID);
        Log.i("selected_items_fav", all_selected_faverit.toString());
        return true;
    }

    public static boolean removeFavID(Integer ID) {
        all_selected_faverit.remove(ID);
        Log.i("selected_items_fav", all_selected_faverit.toString());
        return false;
    }

    public static boolean showFavID(Integer ID) {
        //Log.i("LOG_selected_items_fav",all_selected_faverit.toString());
        return true;
    }

    public static ArrayList<Integer> setSelectedArrayListFav() {
        Log.i("setSelectedArrayList", all_selected_faverit.toString());
        return all_selected_faverit;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiper_market);

        setUpViews(); //first
        onCreateEvents();//second
        getAllCategorys(); //third
    }

    private void setUpViews() {
        btn_goto_homeactivity_from_hiper = (Button) findViewById(R.id.btn_goto_homeactivity_from_hiper);

        dialog_load = new Dialog(HiperMarketActivity.this);

        ryscrview_category = (RecyclerView) findViewById(R.id.ryscrview_category);
        ryscrview_category.setLayoutManager(new LinearLayoutManager(HiperMarketActivity.this));

        ryscrview_product = (RecyclerView) findViewById(R.id.ryscrview_product);
        ryscrview_product.setLayoutManager(new LinearLayoutManager(HiperMarketActivity.this));

        mExampleAdapter_ProRyv = new ExampleAdapter_ProRyv(getApplicationContext(), mExampleList_Pro);
        handler = new Handler();
        thread = new Thread();
        category = new CategoryModel();

        mExampleList_Pro = new ArrayList<>(); //لیست آرایه محصولات pro
        mExampleList = new ArrayList<>();
        userInfoslist = new ArrayList<>();
        //all_selected_pro_items = new ArrayList<Integer>();

        exampleModel_cat = new ExampleItem_model(exampleModel_cat.get$id(), exampleModel_cat.getName(), exampleModel_cat.getID());
        exampleModel_pro = new ExampleItem_ProModel(exampleModel_pro.get$id(), exampleModel_pro.getSupplier(), exampleModel_pro.getProductName(), exampleModel_pro.getProDesc(), exampleModel_pro.getProID(), exampleModel_pro.getPrice(), exampleModel_pro.getImage());

        btn_takmil_karid = (ImageView) findViewById(R.id.btn_takmil_karid);
        txt_sabad_karid_title = (TextView) findViewById(R.id.txt_sabad_karid_title);
        txt_test_var = (TextView) findViewById(R.id.txt_test_var);
        btn_goto_homeactivity = (Button) findViewById(R.id.btn_goto_homeactivity);

        //txt_pro_title = (TextView) findViewById(R.id.txt_pro_title);

        //img_arrow_pro = (ImageView) findViewById(R.id.img_arrow_pro);
    }

    private void onCreateEvents() {

        dialog_load = new Dialog(HiperMarketActivity.this);
        final View itemView = LayoutInflater.from(HiperMarketActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        dialog_load.setContentView(itemView);
        dialog_load.create();
        dialog_load.show();

        int listSize = mExampleList.size();
        for (int i = 0; i < listSize; i++) {
            Log.i("cat_array_val", mExampleList.get(i).toString());
        }

        /*btn_goto_homeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HiperMarketActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

        btn_goto_homeactivity_from_hiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HiperMarketActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_takmil_karid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HiperMarketActivity.this, SefareshBasket.class);
                startActivity(intent);
                finish();
            }
        });

        txt_sabad_karid_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HiperMarketActivity.this, SefareshBasket.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void sendSelectedProductByArrayList(ArrayList proIDArrayList) {
        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, public_recy_pro_api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        exampleModel_pro.set$id(jsonObject.getInt("$id"));
                        exampleModel_pro.setProductName(jsonObject.getString("ProductName"));
                        exampleModel_pro.setSupplier(jsonObject.getString("Supplier"));
                        exampleModel_pro.setProID(jsonObject.getInt("proID"));

                        int $Id = jsonObject.getInt("$id");
                        String ProductName = jsonObject.getString("ProductName");
                        String Supplier = jsonObject.getString("Supplier");
                        int proid = jsonObject.getInt("proID");

                        mExampleList_Pro.add(new ExampleItem_ProModel(exampleModel_pro.get$id(), exampleModel_pro.getProductName(), exampleModel_pro.getSupplier(), exampleModel_pro.getProID()));

                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (mExampleList_Pro.size() != 0) {
                                            if (flag_for_click == true) {
                                                ryscrview_product.setAdapter(new ExampleAdapter_ProRyv(KaridMiveActivity.this, mExampleList_Pro));
                                                adapterIsSet_flag = true;
                                                flag_for_click = false;
                                            }
                                        }
                                    }
                                });
                            }
                        }, 1, 100);
                        if (adapterIsSet_flag == true) {
                            timer.cancel();
                            Log.d("timer_cancel", "timer is canceled");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(KaridMiveActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(KaridMiveActivity.this, "got error", Toast.LENGTH_SHORT).show();
            }
        }) {
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                params.put("ID", ID2_);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);*/
    }

    @Override
    public void onItemClick(int position) {
        flag_for_click = true;
        mExampleList_Pro.clear();
        ExampleItem_model exampleModel_cat = mExampleList.get(position);
        final String cat_name = exampleModel_cat.getName();
        final int ID = exampleModel_cat.getID();
        public_ryv_pro_position = position;
        String ID2 = Integer.toString(ID);
        serverID = ID2;
        ID2_ = ID2;
        String link = recy_pro_api_url + ID2_;
        public_recy_pro_api_url = link;
        Log.d(public_recy_pro_api_url, "final_link");

        getAllProductsByID();
        txt_test_var.setText(exampleModel_cat.getName());
        //img_arrow_pro.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
        //txt_pro_title.setText("از لیست بالا محصول را انتخاب کنید");

        /*Toast.makeText(getApplicationContext(),
                "Name: " + exampleModel_cat.getName() + " ID: " +
                        exampleModel_cat.getID() + " id: " +
                        exampleModel_cat.get$id(), Toast.LENGTH_SHORT).show();*/
    }

    private void getAllCategorys() {

        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, recy_cat_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        category.setId(jsonObject.getInt("$id"));
                        category.setName(jsonObject.getString("Name"));
                        category.setID(jsonObject.getInt("ID"));

                        int $id = jsonObject.getInt("$id");
                        String Name = jsonObject.getString("Name");
                        int ID = jsonObject.getInt("ID");

                        if (ID == 20094) {
                            mExampleList.add(new ExampleItem_model($id, Name, ID));
                        } else {
                            Log.i("must_egnor_", "egnored ids_");
                        }
                        /*if ($id == 7) {
                            mExampleList.add(new ExampleItem_model($id, Name, ID));
                        } else {
                            Log.i("must_egnor_", "egnored ids_");
                        }*/
                    }
                    mExampleAdapter_Ryv = new ExampleAdapter_Ryv(HiperMarketActivity.this, mExampleList);
                    ryscrview_category.setAdapter(mExampleAdapter_Ryv);
                    mExampleAdapter_Ryv.setOnItemClickListener(HiperMarketActivity.this);

                    if (mExampleList.size() != 0) {
                        dialog_load.cancel();
                        dialog_load.dismiss();
                    } else {
                        Log.i("cant_load", "cant_load");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HiperMarketActivity.this, "Error in connection", Toast.LENGTH_SHORT).show();
                Toast.makeText(HiperMarketActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    private void getAllProductsByID() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, public_recy_pro_api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        exampleModel_pro.set$id(jsonObject.getInt("$id"));
                        exampleModel_pro.setProductName(jsonObject.getString("ProductName"));
                        exampleModel_pro.setProDesc(jsonObject.getString("ProductDescription"));
                        exampleModel_pro.setSupplier(jsonObject.getString("Supplier"));
                        exampleModel_pro.setProID(jsonObject.getInt("proID"));
                        exampleModel_pro.setPrice(jsonObject.getInt("Price"));
                        exampleModel_pro.setImage(jsonObject.getString("Image"));

                        int $Id = jsonObject.getInt("$id");
                        String ProductName = jsonObject.getString("ProductName");
                        String ProDesc = jsonObject.getString("ProductDescription");
                        String Supplier = jsonObject.getString("Supplier");
                        int proid = jsonObject.getInt("proID");
                        Double price = jsonObject.getDouble("Price");
                        String Image = jsonObject.getString("Image");

                        mExampleList_Pro.add(new ExampleItem_ProModel(exampleModel_pro.get$id(),
                                                                      exampleModel_pro.getProductName(),
                                                                      exampleModel_pro.getProDesc(),
                                                                      exampleModel_pro.getSupplier(),
                                                                      exampleModel_pro.getProID(),
                                                                      exampleModel_pro.getPrice(),
                                                                      exampleModel_pro.getImage()));

                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (mExampleList_Pro.size() != 0) {
                                            if (flag_for_click == true) {
                                                ryscrview_product.setAdapter(new ExampleAdapter_ProRyv(HiperMarketActivity.this, mExampleList_Pro));
                                                //mExampleAdapter_ProRyv.setOnItemClickListenerPro(KaridMiveActivity.this);
                                                adapterIsSet_flag = true;
                                                flag_for_click = false;
                                            }
                                        }
                                    }
                                });
                            }
                        }, 1, 100);
                        if (adapterIsSet_flag == true) {
                            timer.cancel();
                            Log.d("timer_cancel", "timer is canceled");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HiperMarketActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(HiperMarketActivity.this, "got error", Toast.LENGTH_SHORT).show();
            }
        }) {
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                params.put("ID", ID2_);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}