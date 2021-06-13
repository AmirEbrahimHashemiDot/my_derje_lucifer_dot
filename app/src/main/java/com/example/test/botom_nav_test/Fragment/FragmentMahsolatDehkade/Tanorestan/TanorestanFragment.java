package com.example.test.botom_nav_test.Fragment.FragmentMahsolatDehkade.Tanorestan;

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
import androidx.fragment.app.FragmentPagerAdapter;
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
import com.example.test.botom_nav_test.Adapter.MahsolatDehkade.Goshttaze.GoshtTazeRevAdapter;
import com.example.test.botom_nav_test.Adapter.MahsolatDehkade.Tanorestan.TanorestanRevAdapter;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.GoshtTaze.GoshtTazeModel;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.Tanorestan.TanorestanModel;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TanorestanFragment extends Fragment {

    View view;

    public Context mcontext;

    // Bahare RecyclerView
    public RecyclerView tanorestan_recyclerview;
    public TanorestanRevAdapter tanorestanRVAdapter;
    public TanorestanModel tanorestanitem_model;
    public ArrayList<TanorestanModel> tanorestanItemList;

    //Request to server for get mive list and then filter it for bahare by supliyer fild.
    //Request ex
    public String tanorestan_api_url = "http://171.22.27.135:9099/api/CateGory/GetCategorySale?ID=20094";
    public Dialog dialog_load;

    public TanorestanFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tanorestan, container, false);

        setUpVIews();

        getTanorestanList();

        return view;
    }

    private void getTanorestanList() {

        final JsonArrayRequest goshttaze_request = new JsonArrayRequest(Request.Method.GET, tanorestan_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        tanorestanitem_model.set$id(jsonObject.getInt("$id"));
                        tanorestanitem_model.setID(jsonObject.getInt("proID"));
                        tanorestanitem_model.setSupplier(jsonObject.getString("Supplier"));
                        tanorestanitem_model.setName(jsonObject.getString("ProductName"));
                        tanorestanitem_model.setDescription(jsonObject.getString("ProductDescription"));
                        tanorestanitem_model.setPrice(jsonObject.getInt("Price"));
                        tanorestanitem_model.setImage(jsonObject.getString("Image"));


                        int $id = jsonObject.getInt("$id");
                        int ID = jsonObject.getInt("proID");
                        String Supplier = jsonObject.getString("Supplier");
                        String Name = jsonObject.getString("ProductName");
                        String Description = jsonObject.getString("ProductDescription");
                        int Price = jsonObject.getInt("Price");
                        String Image = jsonObject.getString("Image");


                        //bahareItemList.add(new BahareProItem_model($id, ID, Supplier, Name, Description, Price, Image));
                        //just mive filter

                        if (Supplier.equals(" تنورستان گندمچال")) {
                            tanorestanItemList.add(new TanorestanModel($id, ID, Supplier, Name, Description, Price, Image));
                        } else {
                            //Toast.makeText(getActivity(), "Error in Data Modulation spring Category", Toast.LENGTH_SHORT).show();
                            Log.i("tanorestan_error", "tanorestan filter was egnored :(");
                        }
                    }


                    //set adapter for ry
                    tanorestanRVAdapter = new TanorestanRevAdapter(getActivity(), tanorestanItemList);
                    tanorestan_recyclerview.setAdapter(tanorestanRVAdapter);
                    tanorestan_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

                    if (tanorestanItemList.size() != 0) {
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
        tanorestanitem_model = new TanorestanModel();
        tanorestanRVAdapter = new TanorestanRevAdapter(mcontext, tanorestanItemList);
        tanorestanItemList = new ArrayList<TanorestanModel>();
        tanorestan_recyclerview = (RecyclerView) view.findViewById(R.id.tanorestan_recyclerview);
        tanorestan_recyclerview.setHasFixedSize(true);
        tanorestan_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

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