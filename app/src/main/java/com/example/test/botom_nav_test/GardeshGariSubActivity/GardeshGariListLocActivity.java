package com.example.test.botom_nav_test.GardeshGariSubActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;

public class GardeshGariListLocActivity extends AppCompatActivity {


    public LinearLayout
            btn_loc_list_rosta_khor,
            btn_loc_list_abshar,
            btn_loc_list_tanorestan,
            btn_loc_list_tape_dozdbar,
            btn_loc_list_emam_zade,
            btn_loc_list_sangha_qadimi,
            btn_loc_list_gelochak,
            btn_loc_list_khor_dare,
            btn_loc_list_mile_akar_eski,
            btn_loc_list_isme_cheshme,
            btn_loc_list_zamin_fotbal;

    public Button btn_goto_homeactivity_from_list_amaken_loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardesh_gari_list_loc);

        setUpViews();
    }

    private void setUpViews() {

        btn_loc_list_rosta_khor = (LinearLayout) findViewById(R.id.btn_loc_list_rosta_khor);
        btn_loc_list_abshar = (LinearLayout) findViewById(R.id.btn_loc_list_abshar);
        btn_loc_list_tanorestan = (LinearLayout) findViewById(R.id.btn_loc_list_tanorestan);
        btn_loc_list_tape_dozdbar = (LinearLayout) findViewById(R.id.btn_loc_list_tape_dozdbar);
        btn_loc_list_emam_zade = (LinearLayout) findViewById(R.id.btn_loc_list_emam_zade);
        btn_loc_list_sangha_qadimi = (LinearLayout) findViewById(R.id.btn_loc_list_sangha_qadimi);
        btn_loc_list_gelochak = (LinearLayout) findViewById(R.id.btn_loc_list_gelochak);
        btn_loc_list_khor_dare = (LinearLayout) findViewById(R.id.btn_loc_list_khor_dare);
        btn_loc_list_mile_akar_eski = (LinearLayout) findViewById(R.id.btn_loc_list_mile_akar_eski);
        btn_loc_list_isme_cheshme = (LinearLayout) findViewById(R.id.btn_loc_list_isme_cheshme);
        btn_loc_list_zamin_fotbal = (LinearLayout) findViewById(R.id.btn_loc_list_zamin_fotbal);


        btn_loc_list_rosta_khor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //روستای خور
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'49.1%22N+51%C2%B009'32.0%22E/@35.913646,51.158898,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.913646!4d51.158898"));
                startActivity(intent);
            }
        });
        btn_loc_list_abshar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //آبشار
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/search/%D8%A2%D8%A8%D8%B4%D8%A7%D8%B1+%D8%AE%D9%88%D8%B1%E2%80%AD/@35.9115585,51.1516668,4342m/data=!3m1!1e3"));
                startActivity(intent);
            }
        });
        btn_loc_list_tanorestan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //نان وایی
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/%D9%86%D8%A7%D9%86%D9%88%D8%A7%DB%8C%DB%8C+%D8%AA%D8%A7%D9%81%D8%AA%D9%88%D9%86+%DA%AF%D9%86%D8%AF%D9%85%DA%86%D8%A7%D9%84%E2%80%AD/@35.9147471,51.1572337,184m/data=!3m2!1e3!4b1!4m8!1m2!2m1!1z2KLYqNi02KfYsSDYrtmI2LHigK0!3m4!1s0x3f8dc3defeb465c3:0xa5abdf67e94bf000!8m2!3d35.914746!4d51.1577809"));
                startActivity(intent);
            }
        });
        btn_loc_list_tape_dozdbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //دزدبر
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'58.2%22N+51%C2%B009'23.5%22E/@35.9161568,51.1543398,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.9161568!4d51.1565285?hl=en"));
                startActivity(intent);
            }
        });
        btn_loc_list_emam_zade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //امام زاده
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'58.2%22N+51%C2%B009'23.5%22E/@35.9160482,51.1560489,180m/data=!3m1!1e3!4m5!3m4!1s0x0:0x0!8m2!3d35.9161568!4d51.1565285?hl=en"));
                startActivity(intent);
            }
        });
        btn_loc_list_sangha_qadimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //سنگ های قدیمی
                Toast.makeText(GardeshGariListLocActivity.this, "Location is Not Defined", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse(""));
                startActivity(intent);*/
            }
        });
        btn_loc_list_gelochak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //گِلوچاک
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/Gelochak+Recreational+Area/@35.9056151,51.181586,186a,35y,326.25h/data=!3m1!1e3!4m12!1m6!3m5!1s0x3f8ddd2a8633d30f:0xeffa3b434c36344a!2sIsmeh+Cheshmeh!8m2!3d35.9043425!4d51.1900077!3m4!1s0x3f8ddda08491f2e3:0x10e2b83d37ac537e!8m2!3d35.9057983!4d51.1815738"));
                startActivity(intent);
            }
        });
        btn_loc_list_khor_dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //خور دره
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'16.3%22N+51%C2%B009'59.0%22E/@35.9045411,51.1658418,184m/data=!3m2!1e3!4b1!4m13!1m6!3m5!1s0x3f8ddd2a8633d30f:0xeffa3b434c36344a!2sIsmeh+Cheshmeh!8m2!3d35.9043425!4d51.1900077!3m5!1s0x0:0x0!7e2!8m2!3d35.9045402!4d51.1663895"));
                startActivity(intent);
            }
        });
        btn_loc_list_mile_akar_eski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //میله آخر اسکی
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'33.1%22N+51%C2%B010'37.3%22E/@35.9091835,51.1748323,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.9091835!4d51.177021?hl=en"));
                startActivity(intent);
            }
        });
        btn_loc_list_isme_cheshme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ایسمه چشمه
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/Ismeh+Cheshmeh/@35.9043468,51.187819,737m/data=!3m2!1e3!4b1!4m5!3m4!1s0x3f8ddd2a8633d30f:0xeffa3b434c36344a!8m2!3d35.9043425!4d51.1900077?hl=en"));
                startActivity(intent);
            }
        });
        btn_loc_list_zamin_fotbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //زمین فوتبال
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'56.3%22N+51%C2%B009'54.8%22E/@35.91565,51.1630423,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.91565!4d51.165231"));
                startActivity(intent);
            }
        });

        btn_goto_homeactivity_from_list_amaken_loc = (Button)findViewById(R.id.btn_goto_homeactivity_from_list_amaken_loc);
        btn_goto_homeactivity_from_list_amaken_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GardeshGariListLocActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}