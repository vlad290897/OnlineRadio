@file:Suppress("DEPRECATION")

package com.example.vlad.surfproject

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import com.google.android.exoplayer.ExoPlayer
import com.google.android.exoplayer.FrameworkSampleSource
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.radio_list.*
import java.net.URL

class MainActivity : AppCompatActivity(),Contract.View {
    override fun showList(data: List<Radio>) {
        val adapter = RecyclerAdapter(data)
        rv_radio.adapter = adapter

    }


//    val stream: String = "http://air.radiorecord.ru:8102/tm_320"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_list)
        rv_radio.layoutManager = LinearLayoutManager(this)
        val presenter = Presenter(this)
        presenter.initData()

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



}
