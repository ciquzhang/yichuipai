package com.baichao.yichuipai.core;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jiahuaandroid.basetools.utils.LogUtil;

/**
 * Created by pll on 2017/5/2.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private static final String TAG = "BaseActivity";
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(TAG, "onCreate : " + getClass().getName());
        mContext = this;
        loadContentView();
        this.initViews(savedInstanceState);
        this.initData();
        this.initListener();
    }

    /**
     * 设置监听
     */
    protected void initListener() {

    }

    /**
     * 加载视图的方法
     */
    protected abstract void loadContentView();

    /**
     * initialize the view in the layout
     *
     * @param savedInstanceState 状态信息
     */
    protected void initViews(Bundle savedInstanceState) {

    }

    /**
     * initialize the Activity data
     */
    protected void initData() {

    }
}
