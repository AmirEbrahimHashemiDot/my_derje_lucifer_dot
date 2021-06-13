package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class TelefonZaroryActivity extends AppCompatActivity {

    Button btn_goto_Shoradehyariact_from_telofonzarory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefon_zarory);

        setUpView();
    }

    private void setUpView() {
        btn_goto_Shoradehyariact_from_telofonzarory = (Button)findViewById(R.id.btn_goto_Shoradehyariact_from_telofonzarory);
        btn_goto_Shoradehyariact_from_telofonzarory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelefonZaroryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}