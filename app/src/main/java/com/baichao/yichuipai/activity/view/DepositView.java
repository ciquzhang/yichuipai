package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.DepositBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface DepositView {
    void showToast(String msg);
    void getDatas(List<DepositBean.DataBean> data);
}
