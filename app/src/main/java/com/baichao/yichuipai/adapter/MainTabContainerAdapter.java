package com.baichao.yichuipai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.baichao.yichuipai.R;
import com.fe.library.adapter.BaseAdapter;

/**
 * Created by pll on 2017/5/2.
 */

public class MainTabContainerAdapter extends BaseAdapter {

    private Fragment[] fragmentArray;
    private FragmentManager fragmentManager;

    public MainTabContainerAdapter(FragmentManager fragmentManager, Fragment[] fragmentArray) {
        this.fragmentManager = fragmentManager;
        this.fragmentArray = fragmentArray;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public String[] getTextArray() {
        return new String[]{"首页","说明","拍品","我的"};
    }

    @Override
    public int[] getIconImageArray() {
        return new int[] {R.mipmap.icon_main_b, R.mipmap.icon_explain_b, R.mipmap.icon_hammer_b, R.mipmap.icon_my_b};
    }

    @Override
    public int[] getSelectedIconImageArray() {
        return new int[] {R.mipmap.icon_main_g, R.mipmap.icon_explain_g, R.mipmap.icon_hammer_g, R.mipmap.icon_my_g};
    }

    @Override
    public Fragment[] getFragmentArray() {
        return fragmentArray;
    }

    @Override
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
