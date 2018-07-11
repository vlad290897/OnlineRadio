package com.example.vlad.surfproject

import android.content.Context

interface Contract {

    interface View {
        fun showList(data: List<Radio>)
        fun showRadioPlayer(name: String)
    }

    interface Presenter {
        fun itemClicked(radio: Radio,context: Context)
        fun initData()
        fun onDestroy()
    }

    interface Model {
        fun getRadioList(): List<Radio>
    }

}