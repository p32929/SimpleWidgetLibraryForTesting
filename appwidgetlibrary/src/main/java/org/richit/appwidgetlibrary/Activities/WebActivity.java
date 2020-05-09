package org.richit.appwidgetlibrary.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.appwidgetlibrary.R;

public class WebActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_web);
        } catch (Exception e) {
            // NO WEBVIEW INSTALLED IN YOUR DEVICE
        }
        Log.d(TAG, "onCreate: ");
    }
}
