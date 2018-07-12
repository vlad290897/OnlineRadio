package com.example.vlad.surfproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ButtonListener: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("log","Кнопка play в notification player нажата")
    }
}