package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.fragment.moudule.CollectionBean;
import com.baichao.yichuipai.fragment.view.LiveFragView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/27.
 */

public class LiveFragPresenterImpl implements LiveFragPresenter{

    private Context context;
    private LiveFragView liveFragView;

    public LiveFragPresenterImpl(Context context, LiveFragView liveFragView) {
        this.context = context;
        this.liveFragView = liveFragView;
    }

    @Override
    public void collectHouse(String userId, String houseId, String auctionId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.saveCollection(userId,houseId,auctionId)
                .subscribeOn(Schedulers.newThread())//指定联网线程
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "collection:" + e.getMessage());
                    }

                    @Override
                    public void onNext(CollectionBean collectionBean) {
                        if(collectionBean.getCode().equals("1")){
                            liveFragView.collectSuccess();
                            liveFragView.showToast("收藏成功");
                            ACache.get(context).put("collectionId",collectionBean.getData()+"");
                        }else{
                            liveFragView.showToast(collectionBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void centerCollect(String id, String auctionId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.centerCollection(id,auctionId)
                .subscribeOn(Schedulers.newThread())//指定联网线程
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "centerCollect" + e.getMessage());
                    }

                    @Override
                    public void onNext(CollectionBean collectionBean) {
                        if(collectionBean.getCode().equals("1")){
                            liveFragView.centerCollect();
                            liveFragView.showToast("取消收藏成功");
                        }else {
                            liveFragView.showToast(collectionBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForNewData(String houseId, String auctionId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
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
                        liveFragView.showToast("获取数据错误,可能是网络原因");
                    }

                    @Override
                    public void onNext(HouseInfoDetailBean houseInfoDetailBean) {
                        if(houseInfoDetailBean.getCode().equals("1")){
                            liveFragView.getNewDataSuccess(houseInfoDetailBean.getData());
                        }else{
                            liveFragView.showToast(houseInfoDetailBean.getMsg());
                        }
                    }
                });
    }
}
