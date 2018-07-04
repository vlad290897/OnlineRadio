package com.example.vlad.surfproject

class Presenter(val view: Contract.View): Contract.Presenter {

    val repository = Model()
    override fun initData() {
        val list = repository.getRadioList()
        view.showList(list)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}