package com.example.test.botom_nav_test.ui.dashboard;

//import android.app.Fragment;
import android.app.Dialog;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.test.botom_nav_test.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private WebView webview_site;
    public Dialog load_dialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        /*dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        load_dialog = new Dialog(getContext());
        final View itemView = LayoutInflater.from(getContext()).inflate(R.layout.sefareshgozari_loading, null);
        load_dialog.setContentView(itemView);
        load_dialog.create();
        load_dialog.show();

        webview_site = (WebView)root.findViewById(R.id.webview_site);
        webview_site.setWebViewClient(new WebViewClient());
        webview_site.loadUrl("http://www.derje.ir/");
        WebSettings webSettings = webview_site.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview_site.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    //do your task
                    load_dialog.cancel();
                    load_dialog.dismiss();
                }
            }
        });
        return root;
    }
}