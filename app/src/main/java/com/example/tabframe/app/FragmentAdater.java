package com.example.tabframe.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/28.
 */

public class FragmentAdater extends FragmentPagerAdapter {
   private  String [] title = {"直播","视频","同城"};
    private List<Fragment> fragmentList;
    public FragmentAdater(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
