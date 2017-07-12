package com.baichao.yichuipai.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pll on 2017/5/2.
 */

public abstract class BaseFragment extends Fragment{

    private static final String TAG = "BaseFragment";
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_main, container, false);
        return loadContentView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initViews(savedInstanceState);
        this.initData();
        this.initListener();
    }

    protected void initListener() {

    }

    protected void initViews(Bundle savedInstanceState) {

    }

    protected void initData() {

    }

    protected abstract View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}
