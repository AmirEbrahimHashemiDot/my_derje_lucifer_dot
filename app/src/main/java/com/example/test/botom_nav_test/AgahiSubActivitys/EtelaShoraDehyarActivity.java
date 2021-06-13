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

public class EtelaShoraDehyarActivity extends AppCompatActivity {

    public String etela_url = "http://derje.ir/Home/Jobs?sMrketCd=20105";
    Button btn_goto_agahi_from_etelaie;
    WebView etela_webview;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etela_shora_dehyar);
        setUpViews();

        load_dialog_maharat = new Dialog(EtelaShoraDehyarActivity.this);
        final View itemView = LayoutInflater.from(EtelaShoraDehyarActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        etela_webview.setWebViewClient(new WebViewClient());
        etela_webview.loadUrl(etela_url);
        WebSettings webSettings = etela_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        etela_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_maharat.cancel();
                    load_dialog_maharat.dismiss();
                }
            }
        });

    }

    private void setUpViews() {
        etela_webview = (WebView) findViewById(R.id.etela_webview);
        btn_goto_agahi_from_etelaie = (Button)findViewById(R.id.btn_goto_agahi_from_etelaie);
        btn_goto_agahi_from_etelaie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EtelaShoraDehyarActivity.this, AgahiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
