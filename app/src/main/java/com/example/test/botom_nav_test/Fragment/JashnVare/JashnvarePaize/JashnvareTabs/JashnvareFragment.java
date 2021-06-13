package com.example.test.botom_nav_test.Fragment.JashnVare.JashnvarePaize.JashnvareTabs;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.WebBasketActivity;

public class JashnvareFragment extends Fragment {


    public WebView jashnvare_webview;

    public Dialog load_dialog_jashnvare;
    public String jashnvare_webview_link = "http://www.derje.ir/Home/Jobs?Village=%D8%AE%D9%88%D8%B1&sMrketCd=10081";
    View view;

    public JashnvareFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jashnvare, container, false);

        setUpViews();

        load_dialog_jashnvare = new Dialog(getActivity());
        final View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog_jashnvare.setContentView(itemView);
        load_dialog_jashnvare.create();
        load_dialog_jashnvare.show();

        //showWebview();

        jashnvare_webview.setWebViewClient(new WebViewClient());
        jashnvare_webview.loadUrl(jashnvare_webview_link);
        Log.i("jashn_link_log", jashnvare_webview_link);
        WebSettings webSettings = jashnvare_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        jashnvare_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog_jashnvare.cancel();
                    load_dialog_jashnvare.dismiss();
                }
            }
        });

        return view;
    }

    /*private void showWebview() {
        jashnvare_webview.setWebViewClient(new WebViewClient());
        jashnvare_webview.loadUrl(jashnvare_webview_link);
        Log.i("jashn_link_log", jashnvare_webview_link);
        WebSettings webSettings = jashnvare_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }*/

    private void setUpViews() {
        jashnvare_webview = (WebView) view.findViewById(R.id.jashnvare_webview);
    }
}
