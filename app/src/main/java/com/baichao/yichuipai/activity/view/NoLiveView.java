package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;

/**
 * Created by Administrator on 2017/6/26.
 */

public interface NoLiveView {
    void showToast(String msg);
    void netForItemsSuccess(HouseInfoDetailBean.DataBean dataBean, String houseId, String auctionId);
}
