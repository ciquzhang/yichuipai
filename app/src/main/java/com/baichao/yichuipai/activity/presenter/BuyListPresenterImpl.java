package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.BuyListBean;
import com.baichao.yichuipai.activity.view.BuyListView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/10.
 */

public class BuyListPresenterImpl implements BuyListPresenter {

    private Context context;
    private BuyListView buyListView;
    private int navCount;

    public BuyListPresenterImpl(Context context, BuyListView buyListView) {
        this.context = context;
        this.buyListView = buyListView;
    }

    @Override
    public void netForList(String auctionId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getBuyList(auctionId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BuyListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(BuyListBean buyListBean) {
                        if(buyListBean.getCode().equals("1")){
                            if(buyListBean.getData().getPageData()!=null){
                                navCount = buyListBean.getData().getNavCount();
                                buyListView.refreshSuccess(buyListBean.getData().getPageData());
                            }else{
                                buyListView.refreshSuccess(new ArrayList<BuyListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            buyListView.showToast(buyListBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForMoreList(String auctionId, int pageNum) {
        if(pageNum > navCount){
            buyListView.loadMoreSuccess(new ArrayList<BuyListBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getBuyList(auctionId,pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BuyListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(BuyListBean buyListBean) {
                        if(buyListBean.getCode().equals("1")){
                            if(buyListBean.getData().getPageData()!=null){
                                navCount = buyListBean.getData().getNavCount();
                                buyListView.loadMoreSuccess(buyListBean.getData().getPageData());
                            }else{
                                buyListView.loadMoreSuccess(new ArrayList<BuyListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            buyListView.showToast(buyListBean.getMsg());
                        }
                    }
                });
    }
}
