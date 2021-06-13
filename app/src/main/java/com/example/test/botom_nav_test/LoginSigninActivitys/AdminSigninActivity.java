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

public class AdminSigninActivity extends AppCompatActivity {

    Button btn_goto_home_from_admin_signin;
    EditText edttext_signin_username;
    EditText edttext_signin_enter_password;
    EditText edttext_signin_confirm_password;
    Button btn_signin;
    TextView txt_have_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signin);

        btn_goto_home_from_admin_signin = (Button) findViewById(R.id.btn_goto_home_from_admin_signin);
        edttext_signin_username = (EditText) findViewById(R.id.edttext_signin_username);
        edttext_signin_enter_password = (EditText) findViewById(R.id.edttext_signin_enter_password);
        edttext_signin_confirm_password = (EditText) findViewById(R.id.edttext_signin_confirm_password);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        txt_have_account = (TextView)findViewById(R.id.txt_have_account);

        btn_goto_home_from_admin_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSigninActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminSigninActivity.this, "Server Not Found :(", Toast.LENGTH_SHORT).show();
            }
        });

        txt_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSigninActivity.this, AdminLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}