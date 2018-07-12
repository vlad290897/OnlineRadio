package com.example.vlad.surfproject.ui.player

import com.example.vlad.surfproject.interactor.player.AudioPlayer
import com.example.vlad.surfproject.R

class PlayerPresenter(val view: PlayerContract.View): PlayerContract.Presenter {
    override fun onButtonWasClicked(btn_id: Int) {
        val player = AudioPlayer.instance
        when(btn_id){
            R.id.btn_play_and_pause -> if (player.isPlaying()) player.onStop() else player.onResume()
        }
    }
}