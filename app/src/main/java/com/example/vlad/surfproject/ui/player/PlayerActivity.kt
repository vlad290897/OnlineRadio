package com.example.vlad.surfproject.ui.player

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vlad.surfproject.R
import kotlinx.android.synthetic.main.audio_player.*
import android.content.Intent
import com.example.vlad.surfproject.interactor.player.PlayerService


class PlayerActivity : AppCompatActivity(), PlayerContract.View {
    val presenter = PlayerPresenter(this)
    override fun playerService() {
        presenter.onButtonWasClicked(R.id.btn_play_and_pause)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_player)
        val intent = getIntent()
        val name:String = intent.getStringExtra("rName")
        startService(Intent(this, PlayerService::class.java))
        radio_name.setText(name)
        btn_play_and_pause.setOnClickListener(){
            presenter.onButtonWasClicked(R.id.btn_play_and_pause)
        }
    }
}