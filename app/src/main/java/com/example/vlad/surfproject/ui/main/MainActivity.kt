@file:Suppress("DEPRECATION")

package com.example.vlad.surfproject.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.vlad.surfproject.*
import kotlinx.android.synthetic.main.radio_list.*
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import com.example.vlad.surfproject.model.Radio
import com.example.vlad.surfproject.ui.player.PlayerActivity


class MainActivity : AppCompatActivity(), Contract.View {
    override fun showRadioPlayer(name:String) {
        val intent = Intent(this, PlayerActivity::class.java)
        intent.putExtra("rName",name)
        startActivity(intent)
    }

    override fun showList(data: List<Radio>) {
        val adapter = RecyclerAdapter(data, this)
        rv_radio.adapter = adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_list)
        rv_radio.layoutManager = LinearLayoutManager(this)
        val presenter = MainPresenter(this)
        presenter.initData()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "myChannel"
            val description = "Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val CHANNEL_ID = "31"
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }
}
