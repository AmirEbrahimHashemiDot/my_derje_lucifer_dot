package com.example.test.botom_nav_test.Fragment.JashnVare.JashnvarePaize.JashnvareTabs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.botom_nav_test.Adapter.ExampleAdapter_ProRyv;
import com.example.test.botom_nav_test.MainMenuActivitys.HiperMarketActivity;
import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class PishnahadatFragment extends Fragment {

    //api extras
    public String api_uri = "http://171.22.27.135:5051/api/Message/CreateWithGet";

    public String first_sec_url = "http://171.22.27.135:5051/api/Message/CreateWithGet?";
    public String and_sec = "&";
    public String firstname_sec = "FirstName=";
    public String lastname_sec = "LastName=";
    public String message_sec = "Message=";
    public String phone_sec = "PhoneNumber=";

    /*public String final_url = first_sec_url + firstname_sec + name + and_sec + lastname_sec + fam + and_sec + message_sec + message + and_sec
            + phone_sec + phone + and_sec + type_sec + type_sec_pish;*/

    //?FirstName=amirebrahim&LastName=hashemi&Message=besyarkhob&PhoneNumber=09368515148&Type=2
    public String type_sec = "Type=";
    public String type_sec_pish = "1";
    public String type_sec_entq = "2";
    public String final_url = "";

    //Var
    public String public_user_name;
    public String public_user_fam;
    public String public_user_pish_desc;
    public String public_user_phone;

    //public String send_user_data = "http://171.22.27.135:5051/api/Message/Create";
    public String send_user_data = "http://171.22.27.135:5051/api/Message/CreateWithGet";


    //public Integer public_int_phone_num;
    public EditText edt_pish_name, edt_pish_fam, edt_pish_phone, edt_pish_pish_desc;
    public Button ersla_pishnahad;
    public String public_response;
    //Components
    View view;



    public PishnahadatFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pishnahadat, container, false);

        setUpViews();

        /*if (public_response.equals("1")) {
            edt_pish_name.setText("");
            edt_pish_fam.setText("");
            edt_pish_phone.setText("");
            edt_pish_pish_desc.setText("");
        } else {
            Toast.makeText(getActivity(), "cant clear", Toast.LENGTH_SHORT).show();
        }*/
        //getUserData();

        //sendUserData();

        return view;
    }

    private void generateUrl() {
        final_url = first_sec_url +
                firstname_sec + public_user_name + and_sec +
                lastname_sec + public_user_fam + and_sec +
                message_sec + public_user_pish_desc + and_sec +
                phone_sec + public_user_phone + and_sec +
                type_sec + type_sec_pish;
    }

    private void sendUserData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, final_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getActivity(), "res :" + response, Toast.LENGTH_SHORT).show();
                Log.i("final_link", send_user_data);
                Log.i("response", response);

                public_response = response;

                if (response.equals("1")) {
                    Toast.makeText(getActivity(), "نظر شما دریافت شد.\n با تشکر :)", Toast.LENGTH_SHORT).show();
                } else if (response.isEmpty()) {
                    Toast.makeText(getActivity(), "response is empty", Toast.LENGTH_SHORT).show();
                } else if (response.contains("Error")) {
                    Toast.makeText(getActivity(), "it looks like we got some errors while connecting to server.\n با پشتیبانی تماس بگیرید.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("amir_v_e", "error test: " + error.getMessage());
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "got error", Toast.LENGTH_SHORT).show();
            }
        })/* {
            Map<String, String> params = new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                params.put("FirstName", public_user_name);
                params.put("LastName", public_user_fam);
                params.put("Message", public_user_pish_desc);
                params.put("PhoneNumber", public_user_phone);
                params.put("Type", "2"); // pishnahad type = 2 / enteqad type = 1

                try {
                    Log.i("params", params.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("error_print_param", e.getMessage());
                }

                return params;
            }
        }*/;
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        Log.i("final_link", send_user_data);
    }

    private void getUserData() {
        public_user_name = edt_pish_name.getText().toString();
        public_user_fam = edt_pish_fam.getText().toString();
        public_user_pish_desc = edt_pish_pish_desc.getText().toString();
        public_user_phone = edt_pish_phone.getText().toString();
    }

    private void setUpViews() {
        edt_pish_name = (EditText) view.findViewById(R.id.editTextTextPersonName);
        edt_pish_fam = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        edt_pish_phone = (EditText) view.findViewById(R.id.editTextTextPersonName3);
        edt_pish_pish_desc = (EditText) view.findViewById(R.id.editTextTextPersonName4);
        ersla_pishnahad = (Button) view.findViewById(R.id.button);
        ersla_pishnahad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserData();
                generateUrl();
                sendUserData();

                /*if (public_response.equals("1")) {
                    edt_pish_name.setText("");
                    edt_pish_fam.setText("");
                    edt_pish_phone.setText("");
                    edt_pish_pish_desc.setText("");
                } else {
                    Toast.makeText(getActivity(), "cant clear", Toast.LENGTH_SHORT).show();
                }*/

                /*try {
                    if (public_response.equals("1")) {
                        edt_pish_name.setText("");
                        edt_pish_fam.setText("");
                        edt_pish_phone.setText("");
                        edt_pish_pish_desc.setText("");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
}
