package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.test.botom_nav_test.AgahiSubActivitys.EtelaShoraDehyarActivity;
import com.example.test.botom_nav_test.AgahiSubActivitys.ForoshKalaDastDoActivity;
import com.example.test.botom_nav_test.AgahiSubActivitys.HarajiActivity;
import com.example.test.botom_nav_test.AgahiSubActivitys.TabliqatActivity;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class AgahiActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn_goto_homeactivity;
    LinearLayout btn_forosh_kala_dast_dovom, btn_haraji, btn_tabliqat, btn_etelaie_shora_dehyari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agahi);
        setUpviews();


        /*spinner = (Spinner)findViewById(R.id.agahi_act_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agahi_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/
    }

    private void setUpviews() {
        btn_goto_homeactivity = (Button)findViewById(R.id.btn_goto_homeactivity);
        btn_forosh_kala_dast_dovom = (LinearLayout)findViewById(R.id.btn_forosh_kala_dast_dovom);
        btn_haraji = (LinearLayout)findViewById(R.id.btn_haraji);
        btn_tabliqat = (LinearLayout)findViewById(R.id.btn_tabliqat);
        btn_etelaie_shora_dehyari = (LinearLayout)findViewById(R.id.btn_etelaie_shora_dehyari);

        btn_etelaie_shora_dehyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgahiActivity.this, EtelaShoraDehyarActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_tabliqat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgahiActivity.this, TabliqatActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_haraji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgahiActivity.this, HarajiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_forosh_kala_dast_dovom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgahiActivity.this, ForoshKalaDastDoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_goto_homeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgahiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
