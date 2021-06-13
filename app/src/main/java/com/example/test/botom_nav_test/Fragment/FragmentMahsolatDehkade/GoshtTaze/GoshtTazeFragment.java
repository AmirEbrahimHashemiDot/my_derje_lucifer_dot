package com.example.test.botom_nav_test.Fragment.FragmentMahsolatDehkade.GoshtTaze;

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
import com.example.test.botom_nav_test.Adapter.MahsolatDehkade.Goshttaze.GoshtTazeRevAdapter;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.GoshtTaze.GoshtTazeModel;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GoshtTazeFragment extends Fragment {

    View view;

    public Context mcontext;

    // Bahare RecyclerView
    public RecyclerView gosht_taze_recyclerview;
    public GoshtTazeRevAdapter goshttazeRVAdapter;
    public GoshtTazeModel goshttazeitem_model;
    public ArrayList<GoshtTazeModel> goshttazeItemList;

    //Request to server for get mive list and then filter it for bahare by supliyer fild.
    //Request ex
    public String goshttaze_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=20094";
    public Dialog dialog_load;

    public GoshtTazeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gosht_taze, container, false);
        
        setUpVIews();
        getGoshtTazeList();
        
        return view;
    }

    private void getGoshtTazeList() {
        final JsonArrayRequest goshttaze_request = new JsonArrayRequest(Request.Method.GET, goshttaze_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        goshttazeitem_model.set$id(jsonObject.getInt("$id"));
                        goshttazeitem_model.setID(jsonObject.getInt("proID"));
                        goshttazeitem_model.setSupplier(jsonObject.getString("Supplier"));
                        goshttazeitem_model.setName(jsonObject.getString("ProductName"));
                        goshttazeitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        goshttazeitem_model.setPrice(jsonObject.getInt("Price"));
                        goshttazeitem_model.setImage(jsonObject.getString("Image"));


                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");


                        //bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        //just mive filter




                        if (Supplier.equals("گوشت  تازه")) {
                            goshttazeItemList.add(new GoshtTazeModel($id, ID, Supplier, Name, Description, Price, Image));
                        } else {
                            //Toast.makeText(getActivity(), "Error in Data Modulation spring Category", Toast.LENGTH_SHORT).show();
                            Log.i("goshtaze_error", "goshtaze filter was egnored :(");
                        }
                    }


                    //set adapter for ry
                    goshttazeRVAdapter = new GoshtTazeRevAdapter(getActivity(), goshttazeItemList);
                    gosht_taze_recyclerview.setAdapter(goshttazeRVAdapter);
                    gosht_taze_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

                    if (goshttazeItemList.size() != 0) {
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
                Toast.makeText(getActivity(), "Error in goshttaze api", Toast.LENGTH_SHORT).show();
                Log.i("goshttaze_req_e", error.toString());
            }
        });

        goshttaze_request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        requestQueue.add(goshttaze_request);

        //RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        //RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());


    }

    private void setUpVIews() {

        //bahareProItem_models = new ArrayList<>();
        //bahareItemList = new ArrayList<>();
        goshttazeitem_model = new GoshtTazeModel();
        goshttazeRVAdapter = new GoshtTazeRevAdapter(mcontext, goshttazeItemList);
        goshttazeItemList = new ArrayList<GoshtTazeModel>();
        gosht_taze_recyclerview = (RecyclerView) view.findViewById(R.id.gosht_taze_recyclerview);
        gosht_taze_recyclerview.setHasFixedSize(true);
        gosht_taze_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

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
}
