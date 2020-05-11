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

    private void openWebviewActivityOnClickOf(int viewId, Context context, RemoteViews remoteViews, int type) {
        Intent intent = new Intent(context, MyAppWidget1.class);
        intent.setAction(Global.CLICKED_ON_BTN_WIDGET);
        intent.putExtra(Global.TYPE_OF_WIDGET_CLICK, type);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(viewId, pendingIntent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int i = 0; i < appWidgetIds.length; i++) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.my_app_widget1);
            openWebviewActivityOnClickOf(R.id.livescoreIv, context, remoteViews, Global.CLICKED_ON_LIVESCORES_WIDGET_BTN);
            openWebviewActivityOnClickOf(R.id.tableIv, context, remoteViews, Global.CLICKED_ON_STANDINGS_WIDGET_BTN);
            openWebviewActivityOnClickOf(R.id.schedulesIv, context, remoteViews, Global.CLICKED_ON_SCHEDULES_WIDGET_BTN);
            openWebviewActivityOnClickOf(R.id.searchIv, context, remoteViews, Global.CLICKED_ON_SEARCH_WIDGET_BTN);
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "onReceive: " + intent.getAction());

        if (intent.getAction().equals(Global.CLICKED_ON_BTN_WIDGET)) {
            Intent intentForOpeningActivity = new Intent(context, WebActivity.class);
            intentForOpeningActivity.setAction(Global.CLICKED_ON_BTN_WIDGET);
            intentForOpeningActivity.putExtra(Global.TYPE_OF_WIDGET_CLICK, intent.getIntExtra(Global.TYPE_OF_WIDGET_CLICK, 0));
            intentForOpeningActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentForOpeningActivity);
        }
    }
}

