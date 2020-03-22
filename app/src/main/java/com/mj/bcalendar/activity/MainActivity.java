package com.mj.bcalendar.activity;

import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mj.bcalendar.R;

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
        setListener();
    }

    /**
     * Function Description
     * 디자인 쪽 객체  초기화
     **/
    private void initView(){
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
    }

    private void setListener(){
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();     //닫기
                    }
                });
                alert.setMessage(year + " " + month + " " + dayOfMonth);
                alert.show();
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

}
