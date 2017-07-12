package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.SignBean;
import com.baichao.yichuipai.activity.view.OfferView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/29.
 */

public class OfferPresenterImpl implements OfferPresenter {

    private Context context;
    private OfferView offerView;

    public OfferPresenterImpl(Context context, OfferView offerView) {
        this.context = context;
        this.offerView = offerView;
    }

    @Override
    public void add(String currentPrice, String increasePrice) {
        int current = Integer.parseInt(currentPrice);
        int increase = Integer.parseInt(increasePrice);
        offerView.showPrice(current + increase + "");
    }

    @Override
    public void reduce(String currentPrice, String increasePrice ,String minPrice) {
        int current = Integer.parseInt(currentPrice);
        int increase = Integer.parseInt(increasePrice);
        int min = Integer.parseInt(minPrice);
        if(current - increase < min){
            offerView.showToast("不能再减少啦");
        }else{
            offerView.showPrice(current - increase + "");
        }
    }

    @Override
    public void offerPrice(String auctionId, String userId, String price, String bidNo) {

        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.auctionRecord(auctionId,userId,price,bidNo)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SignBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onNext(SignBean signBean) {
                        if(signBean.getCode().equals("1")) {
                            if(signBean.getData() == 1){
                                offerView.showToast("出价成功");
                                offerView.offerSuccess();
                            }else{
                                offerView.showToast(signBean.getMsg());
                            }
                        }else{
                            offerView.showToast(signBean.getMsg());
                        }
                    }
                });
    }
}
