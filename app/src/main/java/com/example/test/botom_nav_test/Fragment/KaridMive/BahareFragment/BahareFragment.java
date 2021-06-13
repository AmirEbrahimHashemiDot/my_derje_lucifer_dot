package com.example.test.botom_nav_test.Fragment.KaridMive.BahareFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.BasketProAdapter;
import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.KaridMiveActivity;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BahareFragment extends Fragment {

    //public String recy_cat_mive_api_url = "http://171.22.27.135:9099/api/CateGory/GetCateory";
    //public String recy_pro_mive_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=";
    //public ArrayList<BahareProItem_model> bahareProItem_models;
    //public BahareProItem_model bahareProductModel = new BahareProItem_model();

    View view;
    public Context mcontext;

    // Bahare RecyclerView
    public RecyclerView mive_bahare_recyclerview;
    public KaridBahareRevAdapter bahareRVAdapter;
    public BahareProItem_model bahareitem_model;
    public ArrayList<BahareProItem_model> bahareItemList;

    //Request to server for get mive list and then filter it for bahare by supliyer fild.
    //Request ex
    public String bahare_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=20114";
    public Dialog dialog_load;


    public BahareFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mive_bahare, container, false);
        setUpViews();
        getBahareList();
        return view;
    }

    private void setUpViews() {
        //bahareProItem_models = new ArrayList<>();
        //bahareItemList = new ArrayList<>();
        bahareitem_model = new BahareProItem_model();
        bahareRVAdapter = new KaridBahareRevAdapter(mcontext, bahareItemList);
        bahareItemList = new ArrayList<BahareProItem_model>();
        mive_bahare_recyclerview = (RecyclerView) view.findViewById(R.id.mive_bahare_recyclerview);
        mive_bahare_recyclerview.setHasFixedSize(true);
        mive_bahare_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //loading dialog
        dialog_load = new Dialog(getActivity());
        final View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.sefareshgozari_loading, null);
        dialog_load.setContentView(itemView);
        dialog_load.create();
        dialog_load.show();


        Log.i("done_2", "Done 2");
        /*bahareRVAdapter = new KaridBahareRevAdapter(getActivity(), bahareItemList);
        mive_bahare_recyclerview.setAdapter(bahareRVAdapter);*/
    }

    /*
    private void getBahareList() {
        Log.i("done_3", "Done 3");
        StringRequest bahare_stringRequest = new StringRequest(Request.Method.GET, bahare_api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Log.i("done_4", response);
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < response.length(); i++) {
                        //Log.i("done_5", response);
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //Log.i("done_6", response);

                        bahareitem_model.set$id(jsonObject.getInt("$id"));
                        bahareitem_model.setID(jsonObject.getInt("proID"));
                        bahareitem_model.setSupplier(jsonObject.getString("Supplier"));
                        bahareitem_model.setName(jsonObject.getString("ProductName"));
                        bahareitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        bahareitem_model.setPrice(jsonObject.getInt("Price"));
                        bahareitem_model.setImage(jsonObject.getString("Image"));


                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");

                        //Log.i("done_1", response);

                        //just mive filter
                        *//*if (ID == 20114) {
                            //bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                            if (Supplier.equals("میوه های بهاری ")) {
                                bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                            } else {
                                Log.i("bahare_error", "bahare filter was egnored :(");
                            }
                        } else {
                            Log.i("mive_error", "mive filter was egnored :(");
                        }*//*

                        bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));


                        *//*bahareItemList.add(new BahareProItem_model(bahareitem_model.get$id(),
                                                                   bahareitem_model.getID(),
                                                                   bahareitem_model.getSupplier(),
                                                                   bahareitem_model.getName(),
                                                                   bahareitem_model.getDescription(),
                                                                   bahareitem_model.getPrice(),
                                                                   bahareitem_model.getImage()));*//*
                    }

                    //set adapter for ry
                    bahareRVAdapter = new KaridBahareRevAdapter(getActivity(), bahareItemList);
                    mive_bahare_recyclerview.setAdapter(bahareRVAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error in bahare api", Toast.LENGTH_SHORT).show();
                Log.i("bahare_req_e", "bahare api req error");
            }
        }) {
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                //params.put("ID", ID2_);

                return params;
            }
        };

        bahare_stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(bahare_stringRequest);

        //RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        //RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());


    }*/


    private void getBahareList() {
        final JsonArrayRequest bahare_request = new JsonArrayRequest(Request.Method.GET, bahare_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        bahareitem_model.set$id(jsonObject.getInt("$id"));
                        bahareitem_model.setID(jsonObject.getInt("proID"));
                        bahareitem_model.setSupplier(jsonObject.getString("Supplier"));
                        bahareitem_model.setName(jsonObject.getString("ProductName"));
                        bahareitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        bahareitem_model.setPrice(jsonObject.getInt("Price"));
                        bahareitem_model.setImage(jsonObject.getString("Image"));


                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");


                        //bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        //just mive filter


                        if (Supplier.equals("میوه های بهاری ")) {
                            bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        } else {
                            //Toast.makeText(getActivity(), "Error in Data Modulation spring Category", Toast.LENGTH_SHORT).show();
                            Log.i("bahare_error", "bahare filter was egnored :(");
                        }
                    }


                    //set adapter for ry
                    bahareRVAdapter = new KaridBahareRevAdapter(getActivity(), bahareItemList);
                    mive_bahare_recyclerview.setAdapter(bahareRVAdapter);
                    mive_bahare_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

                    if (bahareItemList.size() != 0) {
                        dialog_load.cancel();
                        dialog_load.dismiss();
                    } else {
                        Toast.makeText(mcontext, "cant_load_api", Toast.LENGTH_SHORT).show();
                        Log.i("cant_load", "cant_load");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("json_e", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error in bahare api", Toast.LENGTH_SHORT).show();
                Log.i("bahare_req_e", error.toString());
            }
        });

        bahare_request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        requestQueue.add(bahare_request);

        //RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        //RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());


    }
}
