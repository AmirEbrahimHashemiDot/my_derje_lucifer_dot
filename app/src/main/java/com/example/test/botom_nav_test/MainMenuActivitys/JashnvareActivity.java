package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.botom_nav_test.Fragment.FragmentAdapter.FragmentViewpagerAdapter;
import com.example.test.botom_nav_test.Fragment.JashnVare.JashnvarePaize.JashnvareTabs.EnteqadatFragment;
import com.example.test.botom_nav_test.Fragment.JashnVare.JashnvarePaize.JashnvareTabs.JashnvareFragment;
import com.example.test.botom_nav_test.Fragment.JashnVare.JashnvarePaize.JashnvareTabs.PishnahadatFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.BahareFragment.BahareFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.PaizeFragment.PaizeFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.TabestaneFragment.TabestaneFragment;
import com.example.test.botom_nav_test.Fragment.KaridMive.ZemestaneFragment.ZemestaneFragment;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.google.android.material.tabs.TabLayout;

public class JashnvareActivity extends AppCompatActivity {

    public Button btn_goto_home_from_jashnvare;
    //private AppBarLayout appBarLayout;
    public FragmentViewpagerAdapter adapter;
    public TabLayout tab_list_layout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jashnvare);


        setUpViews();

        setUpFragmentAdapter();
    }

    private void setUpFragmentAdapter() {
        //Adding Fragments
        adapter.AddFragment(new JashnvareFragment(), "جشنواره");
        adapter.AddFragment(new PishnahadatFragment(), "پیشنَهادات");
        adapter.AddFragment(new EnteqadatFragment(), "اِنتِقادات");

        //Setup Adapter
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tab_list_layout.setupWithViewPager(viewPager);
    }

    private void setUpViews() {

        tab_list_layout = (TabLayout) findViewById(R.id.tab_list_layout);
        viewPager = (ViewPager) findViewById(R.id.mive_viewpager);
        adapter = new FragmentViewpagerAdapter(getSupportFragmentManager(), 0);


        btn_goto_home_from_jashnvare = (Button)findViewById(R.id.btn_goto_home_from_jashnvare);
        btn_goto_home_from_jashnvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (JashnvareActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}