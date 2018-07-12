package com.example.vlad.surfproject.ui.main

import android.content.Context

import com.example.vlad.surfproject.interactor.player.AudioPlayer
import com.example.vlad.surfproject.interactor.storage.RadioRepository
import com.example.vlad.surfproject.model.Radio

class MainPresenter(val view: Contract.View): Contract.Presenter {
    override fun itemClicked(radio: Radio, context: Context) {
        view.showRadioPlayer(radio.name)
        val player = AudioPlayer.instance
        player.onPlay(context,radio.stream)
    }

    val repository = RadioRepository()
    override fun initData() {
        val list = repository.getRadioList()
        view.showList(list)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}