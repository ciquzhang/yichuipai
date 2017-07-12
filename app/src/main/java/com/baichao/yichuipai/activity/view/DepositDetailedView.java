package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.DepositDetailedBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface DepositDetailedView {
    void showToast(String msg);
    void refreshSuccess(List<DepositDetailedBean.DataBean.PageDataBean> list);
    void loadMoreSuccessful(List<DepositDetailedBean.DataBean.PageDataBean> list);
}
