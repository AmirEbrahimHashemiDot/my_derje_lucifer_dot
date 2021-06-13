package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Intent;

import com.example.test.botom_nav_test.ShoraDehyariSubActivitys.DehyariActivity;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.ShoraDehyariSubActivitys.ShoraActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ShoraDehyariActivity extends AppCompatActivity {

    Button btn_goto_homeactivity;
    LinearLayout btn_go_to_shora_activity, btn_go_to_dehyari_activity;
    //BottomNavigationView shora_dehyari_nav_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shora_dehyari);
        setUpViewsEvents();


        /*shora_dehyari_nav_bar = (BottomNavigationView)findViewById(R.id.shora_dehyari_nav_bar);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder
                (R.id.navigation_shora_view, R.id.navigation_dehyari_view).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(shora_dehyari_nav_bar, navController);*/
    }

    private void setUpViewsEvents() {
        btn_goto_homeactivity = (Button) findViewById(R.id.btn_goto_homeactivity);
        btn_goto_homeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoraDehyariActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_go_to_shora_activity = (LinearLayout)findViewById(R.id.btn_go_to_shora_activity);
        btn_go_to_shora_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoraDehyariActivity.this, ShoraActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_go_to_dehyari_activity = (LinearLayout)findViewById(R.id.btn_go_to_dehyari_activity);
        btn_go_to_dehyari_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoraDehyariActivity.this, DehyariActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}