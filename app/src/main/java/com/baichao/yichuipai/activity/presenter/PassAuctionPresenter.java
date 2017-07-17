package com.baichao.yichuipai.activity.presenter;

/**
 * Created by Administrator on 2017/7/11.
 */

public interface PassAuctionPresenter {
    void netForList();
    void netForMoreList(int pageNum);
    void addPv(String houseId);
}
