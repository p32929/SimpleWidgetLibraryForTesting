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
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_web);
        } catch (Exception e) {
            Toast.makeText(this, "Webview Not supported", Toast.LENGTH_SHORT).show();
        }

        webView = findViewById(R.id.webview);
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
                Log.d(TAG, "onCreate: Action: " + intent.getAction());
                decideWebviewUrl(intent.getAction());
            } else {
                Log.d(TAG, "onCreate: INTENT ACTION NULL");
            }
        }
    }

    private void decideWebviewUrl(String type) {
        switch (type) {
            case Global.CLICKED_ON_LIVESCORES_WIDGET_BTN:
                webView.loadUrl("https://boavistafc.pt/noticias/");
                break;

            case Global.CLICKED_ON_STANDINGS_WIDGET_BTN:
                webView.loadUrl("https://www.flashscore.pt/futebol/portugal/primeira-liga/classificacoes/");
                break;

            case Global.CLICKED_ON_SCHEDULES_WIDGET_BTN:
                webView.loadUrl("https://www.flashscore.pt/equipa/boavista/n5XEAYKe");
                break;

            case Global.CLICKED_ON_SEARCH_WIDGET_BTN:
                webView.loadUrl(Global.SEARCH_URL);
                break;

            default:
                webView.loadUrl("https://www.google.com/");
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
            finish();
        }
    }
}
