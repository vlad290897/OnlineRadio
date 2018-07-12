package com.example.vlad.surfproject.interactor.player

import android.content.Context

interface Player {
    fun isPlaying(): Boolean
    fun onPlay(context: Context,stream: String)
    fun onStop()
    fun onResume()
}