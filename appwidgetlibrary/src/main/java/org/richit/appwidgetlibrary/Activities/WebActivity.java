package org.richit.appwidgetlibrary.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.appwidgetlibrary.R;

public class WebActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_web);

            WebView webView = new WebView(this);
            webView.setVisibility(View.INVISIBLE);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAppCacheEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDatabaseEnabled(true);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            LinearLayout linearLayoutBottomContainer = findViewById(R.id.bottomLl);
            linearLayoutBottomContainer.addView(webView);

            webView.loadUrl("https://www.google.com/");

        } catch (Exception e) {
            // NO WEBVIEW INSTALLED IN YOUR DEVICE
        }
        Log.d(TAG, "onCreate: ");
    }
}
