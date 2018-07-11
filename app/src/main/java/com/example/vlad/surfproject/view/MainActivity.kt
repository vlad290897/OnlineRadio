@file:Suppress("DEPRECATION")

package com.example.vlad.surfproject.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.vlad.surfproject.*
import com.example.vlad.surfproject.presenter.MainPresenter
import kotlinx.android.synthetic.main.radio_list.*
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build



class MainActivity : AppCompatActivity(), Contract.View {
    override fun showRadioPlayer(name:String) {
        val intent = Intent(this,PlayerActivity::class.java)
        intent.putExtra("rName",name)
        startActivity(intent)
    }

    override fun showList(data: List<Radio>) {
        val adapter = RecyclerAdapter(data,this)
        rv_radio.adapter = adapter
    }


//    val stream: String = "http://air.radiorecord.ru:8102/tm_320"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_list)
        rv_radio.layoutManager = LinearLayoutManager(this)
        val presenter = MainPresenter(this)
        presenter.initData()
        createNotificationChannel()
    /*    b_play.setOnClickListener() {

            val URI = Uri.parse(stream)
            val sampleSource = FrameworkSampleSource(this, URI, null)
            val audioRenderer = MediaCodecAudioTrackRenderer(sampleSource, null, true)
            // Инициализируем плеер
            val exoPlayer = ExoPlayer.Factory.newInstance(1)
            exoPlayer.prepare(audioRenderer)
            // Говорим ему начинать проигрывание аудио, как только будет окончена буферизация
            exoPlayer.setPlayWhenReady(true)

        }*/

    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "myChannel"
            val description = "Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val CHANNEL_ID = "31"
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }




}
