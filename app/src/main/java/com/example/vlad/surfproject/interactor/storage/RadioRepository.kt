package com.example.vlad.surfproject.interactor.storage

import com.example.vlad.surfproject.ui.main.Contract
import com.example.vlad.surfproject.R
import com.example.vlad.surfproject.model.Radio

class RadioRepository : Contract.Model {

    override fun getRadioList(): List<Radio> {
        val radioList = ArrayList<Radio>()
        radioList.add(Radio("Record", R.drawable.radio_record, "http://air.radiorecord.ru:8102/tm_320"))
        radioList.add(Radio("Europa Plus", R.drawable.radio_europa, "http://ep128server.streamr.ru:8030/ep128"))
        radioList.add(Radio("Хорошее", R.drawable.radio_horoshoe, "http://radio.horoshee.fm:8000/mp3"))
        radioList.add(Radio("Love", R.drawable.radio_love, "http://stream.loveradio.ru/12_love_24?type=.aac&UID=9FB85918FA579C1118F5B27A44D17488"))
        radioList.add(Radio("Zaycev", R.drawable.radio_zaycev, "https://zaycevfm.cdnvideo.ru/ZaycevFM_pop_256.mp3"))
        radioList.add(Radio("Юмор", R.drawable.radio_yumor, "http://ic3.101.ru:8000/v5_1"))
        radioList.add(Radio("Жара", R.drawable.radio_zhara, "http://cr2.zharafm.ru:8000/live96.mp3"))
        radioList.add(Radio("Ретро", R.drawable.radio_retro, "http://retroserver.streamr.ru:8043/retro256.mp3"))
        radioList.add(Radio("Радиола", R.drawable.radio_radiola, "http://online1.gkvr.ru:8000/radiola_eka_64.aac"))
        radioList.add(Radio("Rock", R.drawable.radio_rock, "http://nashe.streamr.ru/rock-128.mp3"))
        radioList.add(Radio("Монте-Карло", R.drawable.radio_montecarlo, "http://icecast.radiomontecarlo.cdnvideo.ru:8000/mc_m.aac"))
        return radioList
    }

}