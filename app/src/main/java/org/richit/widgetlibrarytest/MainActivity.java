package org.richit.widgetlibrarytest;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.appwidgetlibrary.WidgetRelated.MyAppWidget1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
//        int appWidgetIds[] = appWidgetManager.getAppWidgetIds(
//                new ComponentName(this, MyAppWidget1.class));
//        Intent pickIntent = new Intent(AppWidgetManager.ACTION_APPWIDGET_PICK);
//        pickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds);
//        startActivityForResult(pickIntent, 123);

        addAppWidget();
    }

    void addAppWidget() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AppWidgetManager mAppWidgetManager = getSystemService(AppWidgetManager.class);

            ComponentName myProvider = new ComponentName(MainActivity.this,
                    MyAppWidget1.class);

            Bundle b = new Bundle();
            b.putString("ggg", "ggg");
            if (mAppWidgetManager.isRequestPinAppWidgetSupported()) {
                Intent pinnedWidgetCallbackIntent = new Intent(MainActivity.this,
                        MyAppWidget1.class);
                PendingIntent successCallback =
                        PendingIntent.getBroadcast(MainActivity.this, 0,
                                pinnedWidgetCallbackIntent, 0);

                mAppWidgetManager.requestPinAppWidget(myProvider, b, successCallback);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
