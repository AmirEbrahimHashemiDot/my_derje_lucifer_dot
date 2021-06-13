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
import android.widget.TableRow;

import com.example.test.botom_nav_test.MainMenuActivitys.AgahiActivity;
import com.example.test.botom_nav_test.R;

public class TabliqatActivity extends AppCompatActivity {

    public String tabliq_url = "http://derje.ir/Home/Jobs?sMrketCd=20106";
    WebView tabliqat_webview;
    Button btn_goto_agahi_from_tabliqat;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabliqat);
        setUpViews();

        load_dialog_maharat = new Dialog(TabliqatActivity.this);
        final View itemView = LayoutInflater.from(TabliqatActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        tabliqat_webview.setWebViewClient(new WebViewClient());
        tabliqat_webview.loadUrl(tabliq_url);
        WebSettings webSettings = tabliqat_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        tabliqat_webview.setWebChromeClient(new WebChromeClient() {
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
        btn_goto_agahi_from_tabliqat = (Button)findViewById(R.id.btn_goto_agahi_from_tabliqat);
        tabliqat_webview = (WebView) findViewById(R.id.tabliqat_webview);
        btn_goto_agahi_from_tabliqat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabliqatActivity.this, AgahiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
