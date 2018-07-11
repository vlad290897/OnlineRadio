package com.example.vlad.surfproject.presenter

import com.example.vlad.surfproject.AudioPlayer
import com.example.vlad.surfproject.PlayerContract
import com.example.vlad.surfproject.R
import kotlinx.android.synthetic.main.audio_player.view.*

class PlayerPresenter(val view: PlayerContract.View): PlayerContract.Presenter {
    override fun onButtonWasClicked(btn_id: Int) {
        val player = AudioPlayer.instance
        when(btn_id){
            R.id.btn_play -> player.onResume()
        }
    }
}