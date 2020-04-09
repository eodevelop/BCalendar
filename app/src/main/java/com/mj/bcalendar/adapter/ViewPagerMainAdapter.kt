package com.mj.bcalendar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mj.bcalendar.fragment.ScheduleFragment
import com.mj.bcalendar.fragment.TodoFragment

class ViewPagerMainAdapter(manager: FragmentManager?, private val mPageCount: Int) : FragmentStatePagerAdapter(manager) {
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> {
                ScheduleFragment()
            }
            1 -> {
                TodoFragment()
            }
            else -> null
        }
    }

    override fun getCount(): Int {
        return mPageCount
    }

}