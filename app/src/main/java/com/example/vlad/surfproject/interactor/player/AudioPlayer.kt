package com.example.vlad.surfproject.interactor.player

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.android.exoplayer.ExoPlaybackException
import com.google.android.exoplayer.ExoPlayer
import com.google.android.exoplayer.FrameworkSampleSource
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer


@Suppress("DEPRECATION")
class AudioPlayer private constructor() : Player {

    lateinit var stream: String
    lateinit var context: Context
    val exoPlayer = ExoPlayer.Factory.newInstance(1)

    override fun onResume() {
        onPlay(context, stream)
    }

    override fun isPlaying(): Boolean {
        if (exoPlayer.playWhenReady == true) {
            return true
        } else {
            return false
        }
    }

    override fun onStop() {
        if (exoPlayer != null) {
            exoPlayer.stop()
        }
    }

    private object Holder {
        val INSTANCE = AudioPlayer()
    }

    companion object {
        val instance: AudioPlayer by lazy { Holder.INSTANCE }
    }

    override fun onPlay(context: Context, stream: String) {
        if (exoPlayer!=null){
            exoPlayer.stop()
        }

        val URI = Uri.parse(stream)
        val sampleSource = FrameworkSampleSource(context, URI, null)
        val audioRenderer = MediaCodecAudioTrackRenderer(sampleSource, null, true)
        exoPlayer.prepare(audioRenderer)
        // Говорим плееру начинать проигрывание аудио, как только будет окончена буферизация
        exoPlayer.setPlayWhenReady(true)
        val list = object : ExoPlayer.Listener {
            override fun onPlayerError(error: ExoPlaybackException?) {
                Log.d("log", "Ошибка вопроизведения")
            }

            override fun onPlayWhenReadyCommitted() {
                Log.d("log", "4")
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playbackState == 1) {
                    Log.d("log", "Воспроизведение")
                }
                if (playbackState == 2) {
                    Log.d("log", "Подготовка")
                }
                if (playbackState == 3) {
                    Log.d("log", "Буферизация")
                }
                if (playbackState == 4) {
                    Log.d("log", "Запуск")
                }
                if (playbackState == 5) {
                    Log.d("log", "Конец")
                }
                if (playbackState == -1) {
                    Log.d("log", "Откл")
                }
            }
        }
        this.context = context
        this.stream = stream
        exoPlayer.addListener(list)
    }
}