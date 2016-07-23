package com.binameer.binameerbusiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.myWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://binameer.com");
        webView.setWebViewClient(new WebViewClient());

    }
}
