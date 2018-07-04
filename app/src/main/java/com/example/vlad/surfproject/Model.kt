package com.example.vlad.surfproject

class Model : Contract.Model {

    override fun getRadioList(): List<Radio> {
        val radioList = ArrayList<Radio>()
        radioList.add(Radio("Радио Свобода", R.drawable.first))
        return radioList
    }

}