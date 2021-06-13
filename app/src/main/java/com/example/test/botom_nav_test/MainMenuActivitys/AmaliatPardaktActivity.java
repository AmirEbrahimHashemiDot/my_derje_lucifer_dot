package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.ApardaktSubActivitys.QrCodeActivity;
import com.example.test.botom_nav_test.R;

public class AmaliatPardaktActivity extends AppCompatActivity {

    LinearLayout btn_cart_be_cart, btn_sharj, btn_pardakt_qabz, btn_qrcode;

    Button btn_goto_homeactivity_from_pardakt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaliat_pardakt);

        btn_cart_be_cart = (LinearLayout)findViewById(R.id.btn_cart_be_cart);
        btn_sharj = (LinearLayout)findViewById(R.id.btn_sharj);
        btn_pardakt_qabz = (LinearLayout)findViewById(R.id.btn_pardakt_qabz);
        btn_qrcode = (LinearLayout)findViewById(R.id.btn_qrcode);
        //btn_goto_homeactivity_from_pardakt = (Button)findViewById(R.id.btn_goto_homeactivity_from_pardakt);

        btn_cart_be_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_sharj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_pardakt_qabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AmaliatPardaktActivity.this, QrCodeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_goto_homeactivity_from_pardakt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AmaliatPardaktActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
