package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;

import com.baichao.yichuipai.fragment.view.AuctionListView;

/**
 * Created by pll on 2017/5/24.
 */

public class AuctionPresenterImpl implements AuctionPresenter{

    private AuctionListView auctionListView;
    private Context context;

    public AuctionPresenterImpl(AuctionListView auctionListView, Context context) {
        this.auctionListView = auctionListView;
        this.context = context;
    }

    @Override
    public void netForActionList() {

    }
}
