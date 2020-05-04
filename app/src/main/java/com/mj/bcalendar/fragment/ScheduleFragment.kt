package com.mj.bcalendar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.mj.bcalendar.R
import com.mj.bcalendar.adapter.ScheduleListViewAdapter

class ScheduleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val scheduleListViewAdapter = ScheduleListViewAdapter(this.requireContext())

        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }
}