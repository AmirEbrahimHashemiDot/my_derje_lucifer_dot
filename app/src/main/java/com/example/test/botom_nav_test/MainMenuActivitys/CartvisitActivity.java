package com.example.test.botom_nav_test.MainMenuActivitys;

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

import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.ShoraDehyariSubActivitys.DehyariActivity;

public class CartvisitActivity extends AppCompatActivity {

    Button btn_goto_Shoradehyariact_from_cart_visit;

    public String cartvisit_url = "http://derje.ir/Home/Jobs?Village=%D8%AE%D9%88%D8%B1&sMrketCd=10067";
    WebView cartvisit_webview;
    public Dialog load_dialog_cartvisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartvisit);

        setUpView();

        load_dialog_cartvisit = new Dialog(CartvisitActivity.this);
        final View itemView = LayoutInflater.from(CartvisitActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_cartvisit.setContentView(itemView);
        load_dialog_cartvisit.create();
        load_dialog_cartvisit.show();

        //********************

        cartvisit_webview.setWebViewClient(new WebViewClient());
        cartvisit_webview.loadUrl(cartvisit_url);
        WebSettings webSettings = cartvisit_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        cartvisit_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_cartvisit.cancel();
                    load_dialog_cartvisit.dismiss();
                }
            }
        });
    }

    private void setUpView() {
        cartvisit_webview = (WebView) findViewById(R.id.cartvisit_webview);
        btn_goto_Shoradehyariact_from_cart_visit = (Button)findViewById(R.id.btn_goto_Shoradehyariact_from_cart_visit);
        btn_goto_Shoradehyariact_from_cart_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartvisitActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}