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

import static com.example.test.botom_nav_test.SefareshgozariSubActivitys.WebBasketActivity.final_Link_show;

public class ShoraActivity extends AppCompatActivity {

    public String shora_url = "http://derje.ir/Home/Jobs?sMrketCd=10038";
    Button btn_goto_shoravadehyariact_from_shora;
    WebView web_basket_webview;
    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shora);
        setUpViewsEvents();

        load_dialog_maharat = new Dialog(ShoraActivity.this);
        final View itemView = LayoutInflater.from(ShoraActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        //********************

        web_basket_webview.setWebViewClient(new WebViewClient());
        web_basket_webview.loadUrl(shora_url);
        WebSettings webSettings = web_basket_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //********************

        web_basket_webview.setWebChromeClient(new WebChromeClient() {
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
        web_basket_webview = (WebView) findViewById(R.id.web_basket_webview);
        btn_goto_shoravadehyariact_from_shora = (Button)findViewById(R.id.btn_goto_shoravadehyariact_from_shora);
        btn_goto_shoravadehyariact_from_shora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoraActivity.this, ShoraDehyariActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
