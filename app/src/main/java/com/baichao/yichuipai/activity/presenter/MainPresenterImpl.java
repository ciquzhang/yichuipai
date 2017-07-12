package com.baichao.yichuipai.activity.presenter;

import android.os.Handler;
import android.os.Message;

import com.baichao.yichuipai.activity.view.MainView;

/**
 * Created by pll on 2017/5/2.
 */

public class MainPresenterImpl implements ApkDownLoadPresenter{

    private MainView mainView;
    /**
     * 标识是否退出
     */
    private static boolean isExit = false;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            isExit = false;
        }
    };

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void isNeedDownLoadApk() {
        boolean needDownLoad = false;
        if(needDownLoad){
            //需要,显示dialog
            mainView.showDownLoadDia();
        }
    }

    @Override
    public void downLoadApk(String ApkUrl) {

    }

    @Override
    public void exit() {
        if (!isExit) {
            isExit = true;
            mainView.showToast("再按一次退出。。。");
            // 利用handler延迟发送更改状态信息
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            mainView.finishActivity();
            System.exit(0);
        }
    }
}
