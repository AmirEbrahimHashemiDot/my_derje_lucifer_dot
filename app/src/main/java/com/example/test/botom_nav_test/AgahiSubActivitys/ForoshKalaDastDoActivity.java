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

public class ForoshKalaDastDoActivity extends AppCompatActivity {

    public String dast_so_url = "http://derje.ir/Home/Jobs?sMrketCd=20108";
    Button btn_goto_agahi_from_dastdo;
    WebView dast_do_webview;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forosh_kala_dast_do);
        setUpviews();

        dast_do_webview = (WebView) findViewById(R.id.dast_do_webview);


        load_dialog_maharat = new Dialog(ForoshKalaDastDoActivity.this);
        final View itemView = LayoutInflater.from(ForoshKalaDastDoActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        dast_do_webview.setWebViewClient(new WebViewClient());
        dast_do_webview.loadUrl(dast_so_url);
        WebSettings webSettings = dast_do_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        dast_do_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_maharat.cancel();
                    load_dialog_maharat.dismiss();
                }
            }
        });

    }

    private void setUpviews() {
        btn_goto_agahi_from_dastdo = (Button)findViewById(R.id.btn_goto_agahi_from_dastdo);
        dast_do_webview = (WebView) findViewById(R.id.dast_do_webview);
        btn_goto_agahi_from_dastdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForoshKalaDastDoActivity.this, AgahiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
