package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.PassAuctionListBean;
import com.baichao.yichuipai.activity.view.PassAuctionView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/11.
 */

public class PassAuctionPresenterImpl implements PassAuctionPresenter {

    private Context context;
    private PassAuctionView passAuctionView;
    private int navCount;

    public PassAuctionPresenterImpl(Context context, PassAuctionView passAuctionView) {
        this.context = context;
        this.passAuctionView = passAuctionView;
    }

    @Override
    public void netForList() {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getPassList()
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PassAuctionListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(PassAuctionListBean passAuctionListBean) {
                        if(passAuctionListBean.getCode().equals("1")){
                            if(passAuctionListBean.getData().getPageData()!=null){
                                navCount = passAuctionListBean.getData().getNavCount();
                                passAuctionView.refreshSuccessful(passAuctionListBean.getData().getPageData());
                            }else{
                                passAuctionView.refreshSuccessful(new ArrayList<PassAuctionListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            passAuctionView.showToast(passAuctionListBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForMoreList(int pageNum) {
        if(pageNum > navCount){
            passAuctionView.loadSuccessful(new ArrayList<PassAuctionListBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getPassList(pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PassAuctionListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(PassAuctionListBean passAuctionListBean) {
                        if(passAuctionListBean.getCode().equals("1")){
                            if(passAuctionListBean.getData().getPageData()!=null){
                                navCount = passAuctionListBean.getData().getNavCount();
                                passAuctionView.loadSuccessful(passAuctionListBean.getData().getPageData());
                            }else{
                                passAuctionView.loadSuccessful(new ArrayList<PassAuctionListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            passAuctionView.showToast(passAuctionListBean.getMsg());
                        }
                    }
                });
    }
}
