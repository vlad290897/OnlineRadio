package com.example.vlad.surfproject

interface Contract {
    interface View{
        fun showList(data: List<Radio>)
    }

    interface Presenter {
      fun initData()
      fun onDestroy()
    }
    interface Model{
        fun getRadioList():List<Radio>

    }

}