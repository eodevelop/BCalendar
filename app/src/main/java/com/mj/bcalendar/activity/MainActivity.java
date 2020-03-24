package com.mj.bcalendar.activity;

import android.view.WindowManager;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.mj.bcalendar.R;
import com.mj.bcalendar.adapter.ViewPagerMainAdapter;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 화면 초기화 부분
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상단 바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        setViewPager();
        setListener();
    }

    /**
     * Function Description
     * 디자인 쪽 객체  초기화
     **/
    private void initView(){
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);

        tlMain = findViewById(R.id.tlMain);
        viewPagerMain = findViewById(R.id.viewPagerMain);
    }

    /**
     * Function Description
     * 메인 화면에서 발생할 이벤트 관련 리스너 모음
     **/
    private void setListener(){

        //달력에서 날짜 변경 시 발생할 이벤트 리스너
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

            }
        });

        //화면의 ViewPager 위젯이 연동되는 TabLayout 설정
        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlMain));

        // 탭 선택시 발생할 리스너
        tlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /*****************************************************************************************************************************/
    //  화면 초기화 마지막 부분
    /*****************************************************************************************************************************/

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // calendarView 관련 설정
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private CalendarView calendarView;

    /*****************************************************************************************************************************/
    //  calendarView 관련 설정 마지막 부분
    /*****************************************************************************************************************************/

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 탭 화면 관련 설정
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private TabLayout tlMain;

    private ViewPager viewPagerMain;
    private ViewPagerMainAdapter viewPagerMainAdapter;

    private void setViewPager(){
        viewPagerMainAdapter = new ViewPagerMainAdapter(getSupportFragmentManager(), tlMain.getTabCount());
        viewPagerMain.setAdapter(viewPagerMainAdapter);
    }

    /*****************************************************************************************************************************/
    //  탭 화면 관련 설정 마지막 부분
    /*****************************************************************************************************************************/
}
