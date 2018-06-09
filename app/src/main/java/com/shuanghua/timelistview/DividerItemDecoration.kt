package com.shuanghua.timelistview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class DividerItemDecoration(private var list: ArrayList<DataBean>,
                            private var dividerHeight: Int = 0) : RecyclerView.ItemDecoration() {

    private val paint1 by lazy { Paint() }//时间轴右边的内容文字画笔
    private val paint2 by lazy { Paint() }//时间轴左边的时间文字画笔
    private val paint3 by lazy { Paint() }//时间轴上的圆形
    private val paint4 by lazy { Paint() }//时间线

    //为绘制时间轴腾出一块特定大小的块空间
    private val timeAreaWidth = 200//内容区域距离左边的距离
    private val timeAreaPaddingTop = 50//内容区域距离右边的距离

    private var timeCircleRadius = 30f//时间轴上圆形图标的半径

    init {
        paint1.color = Color.BLACK
        paint1.textSize = 30f
        paint2.color = Color.DKGRAY
        paint3.color = Color.GREEN
        paint4.color = Color.RED
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?
                                , state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.set(timeAreaWidth, timeAreaPaddingTop, 0, 0)
    }

    /**
     * 整个时间线由上轴线和下轴线拼接而成
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val childCount = parent.childCount
        var childView: View
        for (i in 0 until childCount) {
            childView = parent.getChildAt(i)


            val centerX = childView.left - timeAreaWidth / 3f
            val centerY = childView.top - timeAreaPaddingTop + (timeAreaPaddingTop + childView.height) / 2f

            val startLineY = childView.top - timeAreaPaddingTop
            var stopLineY = centerY - timeCircleRadius
            c.drawLine(centerX, startLineY.toFloat(), centerX, stopLineY, paint4)//上轴线

            stopLineY = childView.bottom.toFloat()
            c.drawLine(centerX, centerY, centerX, stopLineY, paint4)//下轴线
            c.drawCircle(centerX, centerY, timeCircleRadius, paint3)//绘制圆形icon

            //绘制时间轴左边的时间文本
            val position = parent.getChildAdapterPosition(childView)
            val textX = (centerX - timeCircleRadius) / 6
            val textY = centerY + 10

            c.drawText(list[position].time, textX, textY, paint1)
            println("$position")

        }
    }
}