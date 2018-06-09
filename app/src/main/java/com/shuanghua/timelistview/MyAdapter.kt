package com.shuanghua.timelistview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var list: ArrayList<DataBean>? = null

    fun setData(list: ArrayList<DataBean>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun getData(): ArrayList<DataBean>? {
        return list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content
                , parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = if (list != null) list!!.size else 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content?.text = list?.get(position)?.content
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var content: TextView? = null

        init {
            content = itemView.findViewById(R.id.textView)
        }
    }
}