package com.example.test.botom_nav_test.Fragment.KaridMive.TabestaneFragment;

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
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridTabestaneRevAdapter.KaridTabestaneRevAdapter;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.KaridMive.TabestaneModel.TabestaneProItem_model;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TabestaneFragment extends Fragment {


    public Context mcontext;
    // Tabestane RecyclerView
    public RecyclerView mive_tabestane_recyclerview;
    public KaridTabestaneRevAdapter tabestaneRVAdapter;
    public TabestaneProItem_model tabestaneitem_model;
    public ArrayList<TabestaneProItem_model> tabestaneItemList;
    public String bahare_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=20114";
    View view;

    public Dialog dialog_load;

    public TabestaneFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mive_tabestane, container, false);

        setUpViews();
        getTabestaneList();

        return view;
    }

    private void setUpViews() {
        tabestaneitem_model = new TabestaneProItem_model();
        tabestaneRVAdapter = new KaridTabestaneRevAdapter(mcontext, tabestaneItemList);
        tabestaneItemList = new ArrayList<TabestaneProItem_model>();
        mive_tabestane_recyclerview = (RecyclerView) view.findViewById(R.id.mive_tabestane_recyclerview);
        mive_tabestane_recyclerview.setHasFixedSize(true);
        mive_tabestane_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //loading dialog
        dialog_load = new Dialog(getActivity());
        final View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.sefareshgozari_loading, null);
        dialog_load.setContentView(itemView);
        dialog_load.create();
        dialog_load.show();
    }

    private void getTabestaneList() {
        final JsonArrayRequest tabestane_request = new JsonArrayRequest(Request.Method.GET, bahare_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        tabestaneitem_model.set$id(jsonObject.getInt("$id"));
                        tabestaneitem_model.setID(jsonObject.getInt("proID"));
                        tabestaneitem_model.setSupplier(jsonObject.getString("Supplier"));
                        tabestaneitem_model.setName(jsonObject.getString("ProductName"));
                        tabestaneitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        tabestaneitem_model.setPrice(jsonObject.getInt("Price"));
                        tabestaneitem_model.setImage(jsonObject.getString("Image"));

                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");

                        //tabestaneItemList.add(new TabestaneProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        //just mive filter

                        if (Supplier.equals("میوه های تابستانه ")) {
                            tabestaneItemList.add(new TabestaneProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        } else {
                            //Toast.makeText(getActivity(), "Error in Data Modulation spring Category", Toast.LENGTH_SHORT).show();
                            Log.i("bahare_error", "bahare filter was egnored :(");
                        }
                    }

                    //set adapter for ry
                    tabestaneRVAdapter = new KaridTabestaneRevAdapter(getActivity(), tabestaneItemList);
                    mive_tabestane_recyclerview.setAdapter(tabestaneRVAdapter);
                    mive_tabestane_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

                    if (tabestaneItemList.size() != 0) {
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
                Toast.makeText(getActivity(), "Error in tabestane api", Toast.LENGTH_SHORT).show();
                Log.i("tabestane_req_e", error.toString());
            }
        });

        tabestane_request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        requestQueue.add(tabestane_request);

        //RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        //RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
    }
}