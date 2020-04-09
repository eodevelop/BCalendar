package com.mj.bcalendar.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.mj.bcalendar.R
import com.mj.bcalendar.adapter.ViewPagerMainAdapter

class MainActivity : AppCompatActivity() {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 화면 초기화 부분
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //상단 바 제거
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        initView()
        setViewPager()
        setListener()
    }

    /**
     * Function Description
     * 디자인 쪽 객체  초기화
     */
    private fun initView() {
        setContentView(R.layout.activity_main)
        calendarView = findViewById(R.id.calendarView)
        tlMain = findViewById(R.id.tlMain)
        viewPagerMain = findViewById(R.id.viewPagerMain)
    }

    /**
     * Function Description
     * 메인 화면에서 발생할 이벤트 관련 리스너 모음
     */
    private fun setListener() { //달력에서 날짜 변경 시 발생할 이벤트 리스너
        calendarView!!.setOnDateChangeListener { view, year, month, dayOfMonth -> }
        //화면의 ViewPager 위젯이 연동되는 TabLayout 설정
        viewPagerMain!!.addOnPageChangeListener(TabLayoutOnPageChangeListener(tlMain))
        // 탭 선택시 발생할 리스너
        tlMain!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPagerMain!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // **화면 초기화 마지막 부분
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // calendarView 관련 설정
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private var calendarView: CalendarView? = null

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ** calendarView 관련 설정 마지막 부분
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 탭 화면 관련 설정
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private var tlMain: TabLayout? = null
    private var viewPagerMain: ViewPager? = null
    private var viewPagerMainAdapter: ViewPagerMainAdapter? = null
    private fun setViewPager() {
        viewPagerMainAdapter = ViewPagerMainAdapter(supportFragmentManager, tlMain!!.tabCount)
        viewPagerMain!!.adapter = viewPagerMainAdapter
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ** 탭 화면 관련 설정 마지막 부분
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}