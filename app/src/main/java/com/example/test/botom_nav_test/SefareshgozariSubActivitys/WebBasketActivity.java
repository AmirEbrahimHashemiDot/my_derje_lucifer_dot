package com.example.test.botom_nav_test.SefareshgozariSubActivitys;

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

import com.example.test.botom_nav_test.MainMenuActivitys.MaharatActivity;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;

public class WebBasketActivity extends AppCompatActivity {

    public static String final_Link_show;
    //Widgets
    Button btn_goto_Basket_from_Webbasket;
    WebView web_basket_webview;

    public Dialog load_dialog_maharat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_basket);
        setUpViewsEvents();

        load_dialog_maharat = new Dialog(WebBasketActivity.this);
        final View itemView = LayoutInflater.from(WebBasketActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        getLinkIntent();
        webViewShow();

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

    private void webViewShow() {
        web_basket_webview.setWebViewClient(new WebViewClient());
        web_basket_webview.loadUrl(final_Link_show);
        Log.i("wview_link_log", final_Link_show);
        WebSettings webSettings = web_basket_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    private void getLinkIntent() {
        final_Link_show = getIntent().getExtras().getString("final_link_show");
    }

    private void setUpViewsEvents() {
        web_basket_webview = (WebView) findViewById(R.id.web_basket_webview);
        btn_goto_Basket_from_Webbasket = (Button) findViewById(R.id.btn_goto_Basket_from_Webbasket);
        btn_goto_Basket_from_Webbasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                /*Intent intent = new Intent(WebBasketActivity.this, SefareshBasket.class);
                startActivity(intent);
                finish();*/
            }
        });
    }
}