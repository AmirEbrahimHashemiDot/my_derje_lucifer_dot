package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test.botom_nav_test.Fragment.FragmentAdapter.FragmentViewpagerAdapter;
import com.example.test.botom_nav_test.Fragment.KaridMive.BahareFragment.BahareFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.TabestaneFragment.TabestaneFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.PaizeFragment.PaizeFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.ZemestaneFragment.ZemestaneFragment;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;
import com.google.android.material.tabs.TabLayout;

//get date and time
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class KaridMiveTazeActivity_newUI extends AppCompatActivity {

    public Typeface face;
    //private AppBarLayout appBarLayout;
    public FragmentViewpagerAdapter adapter;
    public TabLayout tab_list_layout;
    public ViewPager viewPager;
    private Button btn_goto_home_from_mive_taze;
    public ImageView btn_sabad_karid_from_mivetaze;

    //Date Var
    public String public_date;
    public int int_public_date;
    public int passed_int_to_fragment;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karid_mive_taze_new_u_i);
        setUpView();
        setUpAdapter();
        getDate();
        findCurrentMiveFragment();
    }

    private void findCurrentMiveFragment() {
        /*if (int_public_date > 0 && int_public_date <= 3) {
            passed_int_to_fragment = 3;
        } else if (int_public_date <= 6 && int_public_date > 3) {
            passed_int_to_fragment = 2;
        } else if (int_public_date <= 9 && int_public_date > 6) {
            passed_int_to_fragment = 1;
        } else if (int_public_date <= 12 && int_public_date > 9) {
            passed_int_to_fragment = 0;
        } else {
            Log.i("error_find_fsl", "Error in find fasl");
            Toast.makeText(this, "Error in fasl", Toast.LENGTH_SHORT).show();
        }*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getDate() {
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        String currentDate = dtf.format(now);
        //Toast.makeText(this, currentDate, Toast.LENGTH_SHORT).show();
        Log.i("CurrentDate", currentDate);
        public_date = currentDate;
        int_public_date = Integer.parseInt(currentDate);*/
    }

    private void setUpView() {
        btn_goto_home_from_mive_taze = (Button) findViewById(R.id.btn_goto_home_from_mive_taze);
        btn_sabad_karid_from_mivetaze = (ImageView)findViewById(R.id.btn_sabad_karid_from_mivetaze);
        tab_list_layout = (TabLayout) findViewById(R.id.tab_list_layout);
        viewPager = (ViewPager) findViewById(R.id.mive_viewpager);
        adapter = new FragmentViewpagerAdapter(getSupportFragmentManager(), 0);

        btn_goto_home_from_mive_taze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KaridMiveTazeActivity_newUI.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_sabad_karid_from_mivetaze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KaridMiveTazeActivity_newUI.this, SefareshBasket.class);
                startActivity(intent);
                finish();
            }
        });

        //tabLayout.setSelectedTabIndicator(R.drawable.kharid_mive_bc_tab);
        /*face = Typeface.createFromAsset(getAssets(),"fonts/iransans.ttf");
        tab_list_layout.setTypeface(face);*/
    }

    private void setUpAdapter() {
        //Adding Fragments
        adapter.AddFragment(new ZemestaneFragment(), "زمستانه");
        adapter.AddFragment(new PaizeFragment(), "پاییزه");
        adapter.AddFragment(new TabestaneFragment(), "تابستانه");
        adapter.AddFragment(new BahareFragment(), "بهاره");
        //Setup Adapter
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        tab_list_layout.setupWithViewPager(viewPager);
    }
    /*//set font
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/
}