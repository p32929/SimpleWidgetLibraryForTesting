package org.richit.appwidgetlibrary.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.appwidgetlibrary.Others.Global;
import org.richit.appwidgetlibrary.R;

public class WebActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_web);
        } catch (Exception e) {
            Toast.makeText(this, "Webview Not supported", Toast.LENGTH_SHORT).show();
        }

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "onPageStarted: " + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished: " + url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // ignore ssl error
                Log.d(TAG, "onReceivedSslError: " + view.getUrl());
                if (handler != null) {
                    handler.proceed();
                } else {
                    super.onReceivedSslError(view, null, error);
                }
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            Log.d(TAG, "onCreate: INTENT OK");
            if (intent.getAction() != null) {
                Log.d(TAG, "onCreate: INTENT ACTION OK");
                if (intent.getAction().equals(Global.CLICKED_ON_BTN_WIDGET)) {
                    Log.d(TAG, "onCreate: WIDGET CLICK LOG OK");
                }
            } else {
                Log.d(TAG, "onCreate: INTENT ACTION NULL");
            }
        }

//        if (getIntent().getAction() != null) {
//            Log.d(TAG, "onCreate: " + getIntent().getIntExtra(Global.TYPE_OF_WIDGET_CLICK, 0));
//        } else {
//            finish();
//        }

        webView.loadUrl("https://www.google.com/");
    }
}
