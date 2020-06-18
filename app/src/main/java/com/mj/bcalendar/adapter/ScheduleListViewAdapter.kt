package com.mj.bcalendar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.mj.bcalendar.R
import com.mj.bcalendar.vo.ScheduleVO

class ScheduleListViewAdapter() : BaseAdapter() {

    var scheduleItemList = ArrayList<ScheduleVO>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val context = parent!!.context
        var convertView = convertView

        if(convertView == null){
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.schedule_item, parent, false)
        }

        val txtHour = convertView!!.findViewById<TextView>(R.id.txtHour)
        val txtContent = convertView.findViewById<TextView>(R.id.txtContent)

        val item: ScheduleVO = scheduleItemList.get(position)

        txtHour.setText(item.hour)
        txtContent.setText(item.content)

        return convertView
    }

    override fun getItem(position: Int): Any {
        return scheduleItemList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return scheduleItemList.size
    }

    public fun addItem(hour:String, content:String){
        var item =  ScheduleVO()
        item.hour = hour
        item.content = content

        scheduleItemList.add(item)
    }
}