package com.example.test.botom_nav_test.AgahiSubActivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.test.botom_nav_test.MainMenuActivitys.AgahiActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.WebBasketActivity;

public class HarajiActivity extends AppCompatActivity {

    public String haraji_url = "http://derje.ir/Home/Jobs?sMrketCd=20107";
    Button btn_goto_agahi_from_haraji;
    WebView haraji_webview;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haraji);
        setupViews();

        load_dialog_maharat = new Dialog(HarajiActivity.this);
        final View itemView = LayoutInflater.from(HarajiActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        haraji_webview.setWebViewClient(new WebViewClient());
        haraji_webview.loadUrl(haraji_url);
        WebSettings webSettings = haraji_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        haraji_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_maharat.cancel();
                    load_dialog_maharat.dismiss();
                }
            }
        });
    }

    private void setupViews() {
        haraji_webview = (WebView) findViewById(R.id.haraji_webview);
        btn_goto_agahi_from_haraji = (Button) findViewById(R.id.btn_goto_agahi_from_haraji);
        btn_goto_agahi_from_haraji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HarajiActivity.this, AgahiActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
