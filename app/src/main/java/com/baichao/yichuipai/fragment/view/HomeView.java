package com.baichao.yichuipai.fragment.view;

import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.fragment.moudule.HomeBean;

import java.util.List;

/**
 * Created by pll on 2017/5/3.
 */

public interface HomeView {
    void showToast(String msg);
    void loadSuccessful(List<HomeBean.DataBean.PageDataBean> list);
    void refreshSuccessful(List<HomeBean.DataBean.PageDataBean> list);
    void netForItemsSuccess(HouseInfoDetailBean.DataBean dataBean,String houseId,String auctionId);
}
