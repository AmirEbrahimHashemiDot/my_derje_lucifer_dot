package com.example.test.botom_nav_test.MainMenuActivitys;

import android.app.Dialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
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

public class MaharatActivity extends AppCompatActivity {

    WebView webview_maharat;
    Button btn_goto_homeactivity_from_maharat;
    public Dialog load_dialog_maharat;
    //AlertDialog.Builder alertDialog  = new AlertDialog.Builder(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maharat);

        load_dialog_maharat = new Dialog(MaharatActivity.this);
        final View itemView = LayoutInflater.from(MaharatActivity.this).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_maharat.setContentView(itemView);
        load_dialog_maharat.create();
        load_dialog_maharat.show();

        webview_maharat = (WebView)findViewById(R.id.webview_maharat);
        webview_maharat.setWebViewClient(new WebViewClient());
        webview_maharat.loadUrl("http://derje.ir/Home/Jobs?sMrketCd=10067");
        WebSettings webSettings = webview_maharat.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview_maharat.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_maharat.cancel();
                    load_dialog_maharat.dismiss();
                }
            }
        });



        btn_goto_homeactivity_from_maharat = (Button)findViewById(R.id.btn_goto_homeactivity_from_maharat);
        btn_goto_homeactivity_from_maharat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaharatActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
