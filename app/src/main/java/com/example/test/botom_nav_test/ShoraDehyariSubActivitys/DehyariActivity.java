package com.example.test.botom_nav_test.ShoraDehyariSubActivitys;

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

import com.example.test.botom_nav_test.MainMenuActivitys.ShoraDehyariActivity;
import com.example.test.botom_nav_test.R;

public class DehyariActivity extends AppCompatActivity {

    Button btn_goto_Shoradehyariact_from_dehyari;
    public String dehyari_url = "http://derje.ir/Home/Jobs?sMrketCd=10039";
    WebView dehyari_webview;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dehyari);
        setUpViewsEvents();

        dehyari_webview = (WebView) findViewById(R.id.dehyari_webview);

        load_dialog_maharat = new Dialog(DehyariActivity.this);
        final View itemView = LayoutInflater.from(DehyariActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        dehyari_webview.setWebViewClient(new WebViewClient());
        dehyari_webview.loadUrl(dehyari_url);
        WebSettings webSettings = dehyari_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        dehyari_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_maharat.cancel();
                    load_dialog_maharat.dismiss();
                }
            }
        });

    }

    private void setUpViewsEvents() {
        btn_goto_Shoradehyariact_from_dehyari = (Button)findViewById(R.id.btn_goto_Shoradehyariact_from_dehyari);
        btn_goto_Shoradehyariact_from_dehyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DehyariActivity.this, ShoraDehyariActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
