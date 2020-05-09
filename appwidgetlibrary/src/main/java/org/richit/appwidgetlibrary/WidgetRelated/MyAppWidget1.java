package org.richit.appwidgetlibrary.WidgetRelated;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import org.richit.appwidgetlibrary.Activities.WebActivity;
import org.richit.appwidgetlibrary.Others.Global;
import org.richit.appwidgetlibrary.R;

/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidget1 extends AppWidgetProvider {

    String TAG = this.getClass().getSimpleName();

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.my_app_widget1);
        Intent intent = new Intent(context, MyAppWidget1.class);
        intent.setAction(Global.CLICKED_ON_SEARCH_BTN_WIDGET);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.searchIv, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "onReceive: " + intent.getAction());

        if (intent.getAction().equals(Global.CLICKED_ON_SEARCH_BTN_WIDGET)) {
            Intent intentForOpeningActivity = new Intent(context, WebActivity.class);
            intentForOpeningActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentForOpeningActivity);
        }
    }
}

