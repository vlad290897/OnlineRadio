package com.example.vlad.surfproject.ui.main

import android.content.Context
import com.example.vlad.surfproject.model.Radio

interface Contract {

    interface View {
        fun showList(data: List<Radio>)
        fun showRadioPlayer(name: String)
    }

    interface Presenter {
        fun itemClicked(radio: Radio, context: Context)
        fun initData()
        fun onDestroy()
    }

    interface Model {
        fun getRadioList(): List<Radio>
    }

}