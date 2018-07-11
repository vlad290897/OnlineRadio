package com.example.vlad.surfproject.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.vlad.surfproject.PlayerContract
import com.example.vlad.surfproject.R
import com.example.vlad.surfproject.presenter.PlayerPresenter
import kotlinx.android.synthetic.main.audio_player.*
import android.content.Intent
import com.example.vlad.surfproject.PlayerService


class PlayerActivity : AppCompatActivity(),PlayerContract.View {
    override fun showRadioName() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_player)
        val presenter = PlayerPresenter(this)
        val intent = getIntent()
        startService(Intent(this, PlayerService::class.java))
        val name:String = intent.getStringExtra("rName")
        radio_name.setText(name)
        btn_play.setOnClickListener(){
            presenter.onButtonWasClicked(R.id.btn_play)
        }
    }
}