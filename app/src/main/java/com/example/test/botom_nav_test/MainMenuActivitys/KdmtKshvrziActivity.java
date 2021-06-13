package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class KdmtKshvrziActivity extends AppCompatActivity {

    Button btn_goto_homeactivity_from_kdmt_ksvrzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdmt_kshvrzi);

        setUpView();
    }

    private void setUpView() {
        btn_goto_homeactivity_from_kdmt_ksvrzi = (Button)findViewById(R.id.btn_goto_homeactivity_from_kdmt_ksvrzi);
        btn_goto_homeactivity_from_kdmt_ksvrzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KdmtKshvrziActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}