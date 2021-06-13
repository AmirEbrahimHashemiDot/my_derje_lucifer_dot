package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class RizkharidActivity extends AppCompatActivity {

    Button btn_goto_homeactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rizkharid);

        btn_goto_homeactivity = (Button)findViewById(R.id.btn_goto_homeactivity);
        btn_goto_homeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RizkharidActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
