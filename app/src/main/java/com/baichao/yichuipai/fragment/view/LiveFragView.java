package com.baichao.yichuipai.fragment.view;

import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;

/**
 * Created by Administrator on 2017/6/27.
 */

public interface LiveFragView {
    void showToast(String msg);
    void collectSuccess();
    void centerCollect();
    void getNewDataSuccess(HouseInfoDetailBean.DataBean dataBean);
}
