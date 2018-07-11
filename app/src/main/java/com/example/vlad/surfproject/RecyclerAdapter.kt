package com.example.vlad.surfproject

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vlad.surfproject.presenter.MainPresenter


class RecyclerAdapter(private val radioList: List<Radio>,private val view: Contract.View) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.radio_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = radioList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.img?.setImageResource(radioList[position].background)
        holder?.name?.text = radioList[position].name
        holder?.itemView?.setOnClickListener(){
            Log.d("MyLog", "Position is $position")
            val presenter = MainPresenter(view)
            val context = holder.itemView.context
            presenter.itemClicked(radioList[position],context)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var img:ImageView? = null
        var name:TextView? = null
        init {
            img = itemView?.findViewById(R.id.img_name)
            name = itemView?.findViewById(R.id.txt_name)
        }
    }
}
