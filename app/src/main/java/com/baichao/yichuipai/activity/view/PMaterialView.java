package com.baichao.yichuipai.activity.view;

import android.content.Intent;

/**
 * Created by pll on 2017/5/12.
 */

public interface PMaterialView {
    void startActivityByPicture(Intent intent,int pictureType);
    void showToast(String msg);
    void commitSuccess(Intent intent);
}
