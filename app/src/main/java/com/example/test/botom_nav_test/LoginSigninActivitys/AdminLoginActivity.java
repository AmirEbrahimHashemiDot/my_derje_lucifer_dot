package com.example.test.botom_nav_test.LoginSigninActivitys;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class AdminLoginActivity extends AppCompatActivity {

    Button btn_goto_Home;
    EditText edttext_login_username;
    EditText edttext_login_password;
    Button btn_login;
    TextView txt_need_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        btn_goto_Home = (Button) findViewById(R.id.btn_goto_Home);
        btn_goto_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminLoginActivity.this, "Server Not Found :(", Toast.LENGTH_SHORT).show();
            }
        });

        txt_need_account = (TextView) findViewById(R.id.txt_need_account);
        txt_need_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLoginActivity.this, AdminSigninActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
