package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.AppliedListBean;
import com.baichao.yichuipai.fragment.moudule.HousePvBean;
import com.baichao.yichuipai.fragment.view.AuAppliedView;
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

public class AuAppliedPresenterImpl implements AuAppliedPresenter {

    private AuAppliedView auAppliedView;
    private Context context;
    private int navCount;

    public AuAppliedPresenterImpl(AuAppliedView auAppliedView, Context context) {
        this.auAppliedView = auAppliedView;
        this.context = context;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getAppliedList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppliedListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(AppliedListBean appliedListBean) {
                        if(appliedListBean.getCode().equals("1")){
                            if(appliedListBean.getData()!=null){
                                navCount = appliedListBean.getData().getNavCount();
                                auAppliedView.refreshSuccessful(appliedListBean.getData().getPageData());
                            }else{
                                auAppliedView.refreshSuccessful(new ArrayList<AppliedListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            auAppliedView.showToast(appliedListBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void addPv(String houseId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getHousePv(houseId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HousePvBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "房屋点击量" + e.getMessage());
                    }

                    @Override
                    public void onNext(HousePvBean housePvBean) {
                        if(housePvBean.getCode().equals("1")){
                            Log.e("TAG", "房屋点击量接口成功调用");
                        }else{
                            Log.e("TAG", "房屋点击量接口调用失败");
                        }
                    }
                });
    }

    @Override
    public void netForMoreList(String userId, int pageNum) {
        if(pageNum > navCount){
            auAppliedView.loadMoreSuccessful(new ArrayList<AppliedListBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getAppliedList(userId,pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppliedListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(AppliedListBean appliedListBean) {
                        if(appliedListBean.getCode().equals("1")){
                            navCount = appliedListBean.getData().getNavCount();
                            auAppliedView.loadMoreSuccessful(appliedListBean.getData().getPageData());
                        }else{
                            auAppliedView.showToast(appliedListBean.getMsg());
                        }
                    }
                });
    }
}
