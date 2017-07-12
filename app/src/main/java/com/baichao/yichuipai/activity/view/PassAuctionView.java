package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.PassAuctionListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */

public interface PassAuctionView {
    void showToast(String msg);
    void loadSuccessful(List<PassAuctionListBean.DataBean.PageDataBean> list);
    void refreshSuccessful(List<PassAuctionListBean.DataBean.PageDataBean> list);
}
