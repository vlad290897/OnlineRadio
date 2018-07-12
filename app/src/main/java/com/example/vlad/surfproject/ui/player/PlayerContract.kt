package com.example.vlad.surfproject.ui.player

interface PlayerContract {
    interface View{
        fun playerService()
    }
    interface Presenter{
        fun onButtonWasClicked(btn_id: Int)
    }
}