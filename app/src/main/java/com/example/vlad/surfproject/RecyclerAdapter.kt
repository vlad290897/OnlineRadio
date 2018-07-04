package com.example.vlad.surfproject

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class RecyclerAdapter(private val radios: List<Radio>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.radio_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = radios.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = radios[position].name
        holder?.itemView?.setBackgroundResource(R.drawable.first)

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(v: View?) {
            var position = adapterPosition
                Log.d("MyLog","Position is $position")
        }

        var textView: TextView? = null

        init {
            textView = itemView?.findViewById(R.id.name)
            itemView?.setOnClickListener(this)
            }
        }
}
