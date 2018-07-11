package com.example.vlad.surfproject

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.widget.RemoteViews
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Context
import android.app.NotificationChannel
import android.os.Build
import android.app.PendingIntent
import com.example.vlad.surfproject.view.MainActivity


class PlayerService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        return Service.START_STICKY;
    }
    fun showNotification(){
        Log.d("log","Service")
       val notificationId: Int = 101
        val remoteViews = RemoteViews(packageName, R.layout.notification)
        val intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendInt = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this,"31")
                .setContentIntent(pendInt)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setCustomContentView(remoteViews)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, builder.build())
        remoteViews.setOnClickPendingIntent(R.id.notification_play, getPendingSelfIntent(getApplicationContext(), "pause"));

    }

    protected fun getPendingSelfIntent(context: Context, action: String): PendingIntent {
        Log.e("pause clicked", "done clicking")
        val intent = Intent(context, javaClass)
        intent.action = action
        return PendingIntent.getBroadcast(context, 0, intent, 0)
    }


}