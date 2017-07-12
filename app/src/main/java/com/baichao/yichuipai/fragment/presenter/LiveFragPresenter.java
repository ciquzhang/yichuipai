package com.baichao.yichuipai.fragment.presenter;

/**
 * Created by Administrator on 2017/6/27.
 */

public interface LiveFragPresenter {
    void collectHouse(String userId, String houseId, String auctionId);
    void centerCollect(String id, String auctionId);
    void netForNewData(String houseId, String auctionId);
}
