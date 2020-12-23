package com.example.bai_13_toan_b1704780;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.net.http.*;

public class WebAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView wv = this.findViewById(R.id.webView);
        Intent _it = getIntent();
        String sUrl = _it.getStringExtra("address");
        Toast.makeText(this, sUrl, Toast.LENGTH_LONG).show();
        wv.getSettings().setBuiltInZoomControls(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return (false);
            }
        });

        wv.loadUrl(sUrl);
    }
}