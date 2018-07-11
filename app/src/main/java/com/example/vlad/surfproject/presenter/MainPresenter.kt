package com.example.vlad.surfproject.presenter

import android.content.Context

import com.example.vlad.surfproject.AudioPlayer
import com.example.vlad.surfproject.Contract
import com.example.vlad.surfproject.repository.RadioRepository
import com.example.vlad.surfproject.Radio

class MainPresenter(val view: Contract.View): Contract.Presenter {
    override fun itemClicked(radio: Radio,context: Context) {
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