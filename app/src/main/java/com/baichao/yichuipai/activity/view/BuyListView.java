package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.BuyListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface BuyListView {
    void showToast(String msg);
    void refreshSuccess(List<BuyListBean.DataBean.PageDataBean> data);
    void loadMoreSuccess(List<BuyListBean.DataBean.PageDataBean> data);
}
