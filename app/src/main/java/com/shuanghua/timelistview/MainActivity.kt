package com.shuanghua.timelistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<DataBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initAdapter()

    }

    private fun initData() {
        list = ArrayList()
        for (i in 0 until 10) {
            list.add(DataBean("2018-11", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2018-11", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2018-11", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2018-11", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2017-10", "美国洛杉矶太空宇航局已收件美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2016-09", "太平洋海底快递中心收录,10钟后分发至下一站"))
            list.add(DataBean("2015-08", "月球收件部已记录"))
            list.add(DataBean("2014-07", "已击退外星人,快递安全"))
            list.add(DataBean("2013-06", "遭遇外星人打劫"))
            list.add(DataBean("2012-05", "美国洛杉矶太空宇航局已收件美国洛杉矶太空宇航局已收件美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2011-04", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2010-11", "美国洛杉矶太空宇航局已收件"))
            list.add(DataBean("2009-01", "美国洛杉矶太空宇航局已收件"))
        }
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = MyAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(list, 5))
        recyclerView.adapter = adapter
        adapter.setData(list)

    }
}
