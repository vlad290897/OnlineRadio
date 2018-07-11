package com.example.vlad.surfproject

interface PlayerContract {
    interface View{
        fun showRadioName()
    }
    interface Presenter{
        fun onButtonWasClicked(btn_id: Int)
    }
}