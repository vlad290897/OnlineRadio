package com.example.vlad.surfproject.interactor.player

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.widget.RemoteViews
import com.example.vlad.surfproject.R


class PlayerService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        return Service.START_STICKY
    }

    fun showNotification() {
        Log.d("log", "Service")
        val notificationId: Int = 101
        val remoteViews = RemoteViews(packageName, R.layout.notification)
        val button_intent = Intent("button_clicked")
        val pendingIntent = PendingIntent.getBroadcast(this, 123, button_intent, 0)
        remoteViews.setOnClickPendingIntent(R.id.notification_play, pendingIntent)
        val builder = NotificationCompat.Builder(this, "31")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setCustomContentView(remoteViews)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, builder.build())
    }
}