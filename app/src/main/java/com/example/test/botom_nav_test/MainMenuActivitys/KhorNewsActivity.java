package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class KhorNewsActivity extends AppCompatActivity {

    public Button btn_goto_home_from_khor_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khor_news);

        setUpViews();
    }

    private void setUpViews() {
        btn_goto_home_from_khor_news = (Button)findViewById(R.id.btn_goto_home_from_khor_news);
        btn_goto_home_from_khor_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KhorNewsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}