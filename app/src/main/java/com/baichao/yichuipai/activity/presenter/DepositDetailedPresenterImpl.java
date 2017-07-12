package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.DepositDetailedBean;
import com.baichao.yichuipai.activity.view.DepositDetailedView;
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

public class DepositDetailedPresenterImpl implements DepositDetailedPresenter {

    private Context context;
    private DepositDetailedView depositDetailedView;
    private int navCount;

    public DepositDetailedPresenterImpl(Context context, DepositDetailedView depositDetailedView) {
        this.context = context;
        this.depositDetailedView = depositDetailedView;
    }

    @Override
    public void netForList(String depositId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_DEPOSIT,context).create(NetService.class);
        netService.getDepositDetailedList(depositId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DepositDetailedBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(DepositDetailedBean depositDetailedBean) {
                        if(depositDetailedBean.getCode().equals("1")){
                            navCount = depositDetailedBean.getData().getNavCount();
                            if(depositDetailedBean.getData().getPageData()!=null){
                                depositDetailedView.refreshSuccess(depositDetailedBean.getData().getPageData());
                            }else{
                                depositDetailedView.refreshSuccess(new ArrayList<DepositDetailedBean.DataBean.PageDataBean>());
                            }
                        }else{
                            depositDetailedView.showToast(depositDetailedBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForMoreList(String depositId, int pageNum) {
        if(pageNum > navCount){
            depositDetailedView.loadMoreSuccessful(new ArrayList<DepositDetailedBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_DEPOSIT,context).create(NetService.class);
        netService.getDepositDetailedList(depositId,pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DepositDetailedBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(DepositDetailedBean depositDetailedBean) {
                        if(depositDetailedBean.getCode().equals("1")){
                            navCount = depositDetailedBean.getData().getNavCount();
                            depositDetailedView.loadMoreSuccessful(depositDetailedBean.getData().getPageData());
                        }else{
                            depositDetailedView.showToast(depositDetailedBean.getMsg());
                        }
                    }
                });
    }
}
