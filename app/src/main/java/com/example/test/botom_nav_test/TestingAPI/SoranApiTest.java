package com.example.test.botom_nav_test.TestingAPI;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Model.CategoryModel;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SoranApiTest extends AppCompatActivity {

    public Spinner spn_category, spn_product;
    String spnr_cat_api_url = "http://171.22.27.135:9099/api/CateGory/GetCateory";
    Button btn_req;

    //arrays
    //List<CategoryModel> categorymodellist;
    //ArrayList<String> spinnerArray = new ArrayList<String>();

    ArrayList<String> spinnerItems;// Contains data
    CategoryModel category = new CategoryModel();
    CategoryModel model = new CategoryModel();
    TextView txt_view;

   /* public String $id;
    public String Name;
    public String ID;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soran_api_test);

        spn_category = findViewById(R.id.spn_category);
        spn_product = findViewById(R.id.spn_product);
        btn_req = findViewById(R.id.btn_req);
        spinnerItems = new ArrayList<>();
        txt_view = (TextView)findViewById(R.id.txt_view);


        //Toast.makeText(this, "لطفا کمی صبر کنید.", Toast.LENGTH_SHORT).show();

        //setUpViews();
        getAllCategorys();

       /* $id = model.getName();
        Name = model.getName();
        ID = model.getName();

        spinnerItems.add(model.getName());
        spinnerItems.add("ali");
        spinnerItems.add("reza");*/




        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.select_dialog_item,spinnerItems);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spn_category.setAdapter(spinnerArrayAdapter);

       spn_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String items = "";
                spinnerArrayAdapter.getPosition(items);

                //returnItemIdToServer();
                //String item = parent.getItemAtPosition(position).toString();

                //String item = spinnerArrayAdapter.getItem(spn_category.getSelectedItemPosition());
                //String item = spinnerItems.get(spn_category.getSelectedItemPosition());

                Toast.makeText(SoranApiTest.this, "item is : "+items, Toast.LENGTH_SHORT).show();

                /*if(spinnerItems != null){
                    Toast.makeText(SoranApiTest.this, "item is : "+item, Toast.LENGTH_SHORT).show();
                    txt_view.setText(item);
                }else {
                    Toast.makeText(SoranApiTest.this, "fuck", Toast.LENGTH_SHORT).show();
                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("not_clicked",":(");
            }
        });



        //Toast.makeText(this, spinnerItems.toString(), Toast.LENGTH_SHORT).show();
        //Log.d("var_v1",categorymodellist.toString());
        Log.d("var_v2",spinnerItems.toString());
        //Log.d("var_v3",spinnerArray.toString());
        Log.d("var_v4",spinnerArrayAdapter.toString());
    }

    private void returnItemIdToServer() {



    }

    private void getAllCategorys() {

        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, spnr_cat_api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        CategoryModel category = new CategoryModel();

                        //*-*-*
                        category.setId(jsonObject.getInt("$id"));
                        category.setName(jsonObject.getString("Name"));
                        category.setID(jsonObject.getInt("ID"));
                        //*-*-*

                        String Name = jsonObject.getString("Name");

                        spinnerItems.add(Name);
/*
                        $id = category.getName();
                        Name = category.getName();
                        ID = category.getName();
*/


                        //spinnerItems.add(model.getName());

                        //Log.d("var_v1",categorymodellist.toString());
                        Log.d("var_v2",spinnerItems.toString());
                        //Log.d("var_v3",spinnerArray.toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SoranApiTest.this, "Error in connection", Toast.LENGTH_SHORT).show();
                Toast.makeText(SoranApiTest.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    private void setUpViews() {
        spn_category = findViewById(R.id.spn_category);
        spn_product = findViewById(R.id.spn_product);
        btn_req = findViewById(R.id.btn_req);
        spinnerItems = new ArrayList<>();
        //categorymodellist = new ArrayList<>();
    }
}