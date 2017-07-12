package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.MeetingListBean;
import com.baichao.yichuipai.activity.view.AuctionMeetingView;
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

public class AuctionMeetingPresenterImpl implements AuctionMeetingPresenter {

    private Context context;
    private AuctionMeetingView auctionMeetingView;

    public AuctionMeetingPresenterImpl(Context context, AuctionMeetingView auctionMeetingView) {
        this.context = context;
        this.auctionMeetingView = auctionMeetingView;
    }

    @Override
    public void netForList(String auctionMeetingId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.getMeetingList(auctionMeetingId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MeetingListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(MeetingListBean meetingListBean) {
                        if(meetingListBean.getCode().equals("1")){
                            if(meetingListBean.getData()!=null){
                                auctionMeetingView.refreshSuccess(meetingListBean.getData());
                            }else{
                                auctionMeetingView.refreshSuccess(new ArrayList<MeetingListBean.DataBean>());
                            }
                        }else{
                            auctionMeetingView.showToast(meetingListBean.getMsg());
                        }
                    }
                });
    }
}
