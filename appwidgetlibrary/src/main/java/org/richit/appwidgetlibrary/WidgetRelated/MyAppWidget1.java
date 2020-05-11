package org.richit.appwidgetlibrary.WidgetRelated;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import org.richit.appwidgetlibrary.Others.Global;
import org.richit.appwidgetlibrary.R;

/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidget1 extends AppWidgetProvider {

    String TAG = this.getClass().getSimpleName();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int i = 0; i < appWidgetIds.length; i++) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.my_app_widget1);
            Global.openWebviewActivityOnClickOf(R.id.livescoreIv, context, remoteViews, Global.CLICKED_ON_LIVESCORES_WIDGET_BTN);
            Global.openWebviewActivityOnClickOf(R.id.tableIv, context, remoteViews, Global.CLICKED_ON_STANDINGS_WIDGET_BTN);
            Global.openWebviewActivityOnClickOf(R.id.schedulesIv, context, remoteViews, Global.CLICKED_ON_SCHEDULES_WIDGET_BTN);
            Global.openWebviewActivityOnClickOf(R.id.searchIv, context, remoteViews, Global.CLICKED_ON_SEARCH_WIDGET_BTN);
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }
    }
}

