package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test.botom_nav_test.Baskets.TanorestanBasket.TanorestanBasket;
import com.example.test.botom_nav_test.Fragment.FragmentAdapter.FragmentViewpagerAdapter;
import com.example.test.botom_nav_test.Fragment.FragmentMahsolatDehkade.GoshtTaze.GoshtTazeFragment;
import com.example.test.botom_nav_test.Fragment.FragmentMahsolatDehkade.Tanorestan.TanorestanFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.BahareFragment.BahareFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.PaizeFragment.PaizeFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.TabestaneFragment.TabestaneFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.ZemestaneFragment.ZemestaneFragment;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;
import com.google.android.material.tabs.TabLayout;

import java.net.Inet4Address;

public class MahsolatDehkadeActivity extends AppCompatActivity {

    public FragmentViewpagerAdapter adapter;
    public TabLayout mahsol_deh_tab_list_layout;
    public ViewPager mahsolat_dehkade_viewpager;
    Button btn_goto_home_from_mahsolat_dehkade;
    //ImageView btn_sabad_karid_from_mahsolat_dehkade;
    public static LinearLayout tanorestan_shorcut_basket_lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahsolat_dehkade);

        setUpViews();
        setUpAdapter();
    }

    private void setUpAdapter() {

        //Adding Fragments
        adapter.AddFragment(new GoshtTazeFragment(), "گوشت تازه");
        adapter.AddFragment(new TanorestanFragment(), "تَنورِستان");

        //Setup Adapter
        mahsolat_dehkade_viewpager.setAdapter(adapter);
        mahsolat_dehkade_viewpager.setCurrentItem(1);
        mahsol_deh_tab_list_layout.setupWithViewPager(mahsolat_dehkade_viewpager);

    }

    private void setUpViews() {

        tanorestan_shorcut_basket_lin = (LinearLayout) findViewById(R.id.tanorestan_shorcut_basket_lin);
        tanorestan_shorcut_basket_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MahsolatDehkadeActivity.this, TanorestanBasket.class);
                startActivity(intent);
                finish();
            }
        });
        mahsol_deh_tab_list_layout = (TabLayout) findViewById(R.id.mahsol_deh_tab_list_layout);
        mahsolat_dehkade_viewpager = (ViewPager) findViewById(R.id.mahsolat_dehkade_viewpager);

        adapter = new FragmentViewpagerAdapter(getSupportFragmentManager(), 0);

        btn_goto_home_from_mahsolat_dehkade = (Button) findViewById(R.id.btn_goto_home_from_mahsolat_dehkade);
        btn_goto_home_from_mahsolat_dehkade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MahsolatDehkadeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //btn_sabad_karid_from_mahsolat_dehkade = (ImageView) findViewById(R.id.btn_sabad_karid_from_mahsolat_dehkade);
        /*btn_sabad_karid_from_mahsolat_dehkade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MahsolatDehkadeActivity.this, SefareshBasket.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}