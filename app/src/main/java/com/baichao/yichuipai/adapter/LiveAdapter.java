package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/26.
 */

public class LiveAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    public LiveAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments, ArrayList<String> titles) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
