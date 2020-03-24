package com.mj.bcalendar.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.mj.bcalendar.fragment.ScheduleFragment;
import com.mj.bcalendar.fragment.TodoFragment;

public class ViewPagerMainAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public ViewPagerMainAdapter(FragmentManager manager, int pageCount){
        super(manager);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ScheduleFragment scheduleFragment = new ScheduleFragment();
                return scheduleFragment;

            case 1:
                TodoFragment todoFragment = new TodoFragment();
                return todoFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
