package com.example.test.botom_nav_test.SettingsActivity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SettingsSubActivitys.TamasDerjeActivity;

public class SettingsActivity extends AppCompatActivity {

    Button btn_goto_homeactivity_from_settings, btn_ertebat_ba_derje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btn_goto_homeactivity_from_settings = (Button) findViewById(R.id.btn_goto_homeactivity_from_settings);
        btn_goto_homeactivity_from_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //btn_ertebat_ba_derje = (Button)findViewById(R.id.btn_ertebat_ba_derje);
    }
}