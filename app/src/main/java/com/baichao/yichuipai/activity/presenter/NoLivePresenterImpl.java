package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.activity.view.NoLiveView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/26.
 */

public class NoLivePresenterImpl implements NoLivePresenter {

    private Context context;
    private NoLiveView noLiveView;

    public NoLivePresenterImpl(Context context, NoLiveView noLiveView) {
        this.context = context;
        this.noLiveView = noLiveView;
    }

    @Override
    public void netForItemList(final String houseId, final String auctionId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        //判断是否为登录状态
        if(ACache.get(context).getAsString("userId")!=null && ACache.get(context).getAsString("userId").equals("")!=true){
            //登录
            netService.getHouseInfoDetail(ACache.get(context).getAsString("userId"),houseId,auctionId)
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<HouseInfoDetailBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "nolive:" + e.getMessage());
                        }

                        @Override
                        public void onNext(HouseInfoDetailBean houseInfoDetailBean) {
                            if(houseInfoDetailBean.getCode().equals("1")){
                                noLiveView.netForItemsSuccess(houseInfoDetailBean.getData(),houseId,auctionId);
                            }else{
                                noLiveView.showToast(houseInfoDetailBean.getMsg());
                            }
                        }
                    });
        }else{
            //未登录
            netService.getHouseInfoDetail(houseId,auctionId)
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<HouseInfoDetailBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "nolive:" + e.getMessage());
                        }

                        @Override
                        public void onNext(HouseInfoDetailBean houseInfoDetailBean) {
                            if(houseInfoDetailBean.getCode().equals("1")){
                                noLiveView.netForItemsSuccess(houseInfoDetailBean.getData(),houseId,auctionId);
                            }else{
                                noLiveView.showToast(houseInfoDetailBean.getMsg());
                            }
                        }
                    });
        }
    }
}
