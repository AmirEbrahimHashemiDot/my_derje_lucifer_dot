package com.example.test.botom_nav_test.SettingsSubActivitys;

import android.content.ClipboardManager;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SettingsActivity.SettingsActivity;

public class TamasDerjeActivity extends AppCompatActivity {

    Button btn_goto_settingsactivity, btn_copy_info;

    TextView txt_website, txt_email, txt_phone, txt_address;

    String text_website, text_email, text_phone, text_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamas_derje);

        btn_goto_settingsactivity = (Button) findViewById(R.id.btn_goto_settingsactivity);
        btn_goto_settingsactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TamasDerjeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txt_website = (TextView) findViewById(R.id.txt_website);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        txt_address = (TextView) findViewById(R.id.txt_address);


        btn_copy_info = (Button) findViewById(R.id.btn_copy_info);

        btn_copy_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_website = txt_website.getText().toString();
                text_email = txt_email.getText().toString();
                text_phone = txt_phone.getText().toString();
                text_address = txt_address.getText().toString();

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                clipboardManager.setText(text_website + "\n" + text_email + "\n" + text_phone + "\n" + text_address);
                Toast.makeText(TamasDerjeActivity.this, "copied to clipboard :)", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
