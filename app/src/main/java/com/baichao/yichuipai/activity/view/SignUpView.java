package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.NeedDepositBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public interface SignUpView {
    void showToast(String msg);
    void signSuccess();
    void depositSuccess(List<NeedDepositBean.DataBean> data);
}
