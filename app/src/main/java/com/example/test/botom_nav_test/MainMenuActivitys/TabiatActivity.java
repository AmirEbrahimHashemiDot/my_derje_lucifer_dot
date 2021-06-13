package com.example.test.botom_nav_test.MainMenuActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.ShoraDehyariSubActivitys.ShoraActivity;

public class TabiatActivity extends AppCompatActivity {

    public TextView txtlistagahi;
    Button btn_goto_home_from_tabiat;
    public Dialog load_dialog_tabiat;
    WebView tabiat_webview;
    public String tabiat_url = "http://derje.ir/Home/Jobs?Village=%D8%AE%D9%88%D8%B1&sMrketCd=20110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabiat);

        setUpView();

        //loadTextAnim();


        load_dialog_tabiat = new Dialog(TabiatActivity.this);
        final View itemView = LayoutInflater.from(TabiatActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_tabiat.setContentView(itemView);
        load_dialog_tabiat.create();
        load_dialog_tabiat.show();

        tabiat_webview.setWebViewClient(new WebViewClient());
        tabiat_webview.loadUrl(tabiat_url);
        WebSettings webSettings = tabiat_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        tabiat_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_tabiat.cancel();
                    load_dialog_tabiat.dismiss();
                }
            }
        });
    }

    private void loadTextAnim() {

        /*try {
            YoYo.with(Techniques.Hinge)*//*Tada*//*
                    .duration(1000)
                    .repeat(5)
                    .playOn(findViewById(R.id.txtlistagahi));
        } catch (Exception anim_e) {
            anim_e.printStackTrace();
            Log.i("anim_error", anim_e.getMessage().toString());
        }*/
    }

    private void setUpView() {
        txtlistagahi = (TextView)findViewById(R.id.txtlistagahi);
        tabiat_webview = (WebView)findViewById(R.id.tabiat_webview);
        btn_goto_home_from_tabiat = (Button)findViewById(R.id.btn_goto_home_from_tabiat);
        btn_goto_home_from_tabiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabiatActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}