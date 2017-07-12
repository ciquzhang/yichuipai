package com.baichao.yichuipai.activity.presenter;

/**
 * Created by Administrator on 2017/6/29.
 */

public interface OfferPresenter {
    void add(String currentPrice,String increasePrice);
    void reduce(String currentPrice,String increasePrice,String minPrice);
    void offerPrice(String auctionId,String userId,String price,String bidNo);
}
