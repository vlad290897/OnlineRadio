package com.example.vlad.surfproject

import android.content.Context

interface Player {
    fun onPlay(context: Context,stream: String)
    fun onStop()
    fun onResume()

}