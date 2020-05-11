package org.richit.appwidgetlibrary.Others;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import org.richit.appwidgetlibrary.Activities.WebActivity;

public class Global {
    // Pending Intent Actions
    public static final String CLICKED_ON_BTN_WIDGET = "CLICKED_ON_BTN_WIDGET";

    public static final String SEARCH_URL = "https://cse.google.com/cse?cx=partner-pub-5633310963159932:9769524521";

    //
    public static final String TYPE_OF_WIDGET_CLICK = "TYPE_OF_WIDGET_CLICK";
    public static final String CLICKED_ON_LIVESCORES_WIDGET_BTN = "CLICKED_ON_LIVESCORES_WIDGET_BTN";
    public static final String CLICKED_ON_STANDINGS_WIDGET_BTN = "CLICKED_ON_STANDINGS_WIDGET_BTN";
    public static final String CLICKED_ON_SCHEDULES_WIDGET_BTN = "CLICKED_ON_SCHEDULES_WIDGET_BTN";
    public static final String CLICKED_ON_SEARCH_WIDGET_BTN = "CLICKED_ON_SEARCH_WIDGET_BTN";

    //
    public static void openWebviewActivityOnClickOf(int viewId, Context context, RemoteViews remoteViews, String action) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.setAction(action);
        intent.putExtra(Global.TYPE_OF_WIDGET_CLICK, viewId);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(viewId, pendingIntent);
    }
}
