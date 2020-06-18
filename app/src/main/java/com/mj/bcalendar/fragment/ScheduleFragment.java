package com.mj.bcalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;
import com.mj.bcalendar.adapter.ScheduleListViewAdapter;

public class ScheduleFragment extends ListFragment {

    ScheduleListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new ScheduleListViewAdapter();

        setListAdapter(adapter);
        createAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void createAdapter(ScheduleListViewAdapter adapter){
        for(int i = 0; i  < 24; i++){
            String hour = "";
            int temp = i + 1;
            if(temp < 10){
                hour = "0" + temp + ":00";
            } else {
                hour = temp + ":00";
            }

             adapter.addItem(hour, "Test");
        }
    }
}
