package com.example.test.botom_nav_test.Fragment.KaridMive.ZemestaneFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
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
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridZmstaneRevAdapter.KaridZmstaneRevAdapter;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.KaridMive.ZemestaneModel.ZemestaneProItem_model;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ZemestaneFragment extends Fragment {

    View view;
    public Context mcontext;

    //Zemestane RecyclerView
    public RecyclerView mive_zemestane_recyclerview;
    public KaridZmstaneRevAdapter zemestaneRVAdapter;
    public ZemestaneProItem_model zemestaneitem_model;
    public ArrayList<ZemestaneProItem_model> zemestaneItemList;

    public String zmstne_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=20114";
    public Dialog dialog_load;

    public ZemestaneFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mive_zemestane, container, false);

        setUpViews();
        getZemestaneList();

        return view;
    }


    private void setUpViews() {
        zemestaneitem_model = new ZemestaneProItem_model();
        zemestaneRVAdapter = new KaridZmstaneRevAdapter(mcontext, zemestaneItemList);
        zemestaneItemList = new ArrayList<ZemestaneProItem_model>();
        mive_zemestane_recyclerview = (RecyclerView) view.findViewById(R.id.mive_zemestane_recyclerview);
        mive_zemestane_recyclerview.setHasFixedSize(true);
        mive_zemestane_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        dialog_load = new Dialog(getActivity());
        final View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.sefareshgozari_loading, null);
        dialog_load.setContentView(itemView);
        dialog_load.create();
        dialog_load.show();
    }

    private void getZemestaneList() {
        final JsonArrayRequest zemestane_request = new JsonArrayRequest(Request.Method.GET, zmstne_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        zemestaneitem_model.set$id(jsonObject.getInt("$id"));
                        zemestaneitem_model.setID(jsonObject.getInt("proID"));
                        zemestaneitem_model.setSupplier(jsonObject.getString("Supplier"));
                        zemestaneitem_model.setName(jsonObject.getString("ProductName"));
                        zemestaneitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        zemestaneitem_model.setPrice(jsonObject.getInt("Price"));
                        zemestaneitem_model.setImage(jsonObject.getString("Image"));


                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");


                        //zemestaneItemList.add(new ZemestaneProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        //just mive filter


                        if (Supplier.equals("میوه های زمستانه ")) {
                            zemestaneItemList.add(new ZemestaneProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        } else {
                            //Toast.makeText(getActivity(), "Error in Data Modulation spring Category", Toast.LENGTH_SHORT).show();
                            Log.i("bahare_error", "bahare filter was egnored :(");
                        }
                    }


                    //set adapter for ry
                    zemestaneRVAdapter = new KaridZmstaneRevAdapter(getActivity(), zemestaneItemList);
                    mive_zemestane_recyclerview.setAdapter(zemestaneRVAdapter);
                    mive_zemestane_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

                    if (zemestaneItemList.size() != 0) {
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

        zemestane_request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        requestQueue.add(zemestane_request);
    }
}