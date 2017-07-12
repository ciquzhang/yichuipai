package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.DepositBean;
import com.baichao.yichuipai.activity.view.DepositView;
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

public class DepositPresenterImpl implements DepositPresenter {

    private Context context;
    private DepositView depositView;

    public DepositPresenterImpl(Context context, DepositView depositView) {
        this.context = context;
        this.depositView = depositView;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.getDepositList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DepositBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(DepositBean depositBean) {
                        if(depositBean.getCode().equals("1")){
                            if(depositBean.getData()!=null){
                                depositView.getDatas(depositBean.getData());
                            }else {
                                depositView.getDatas(new ArrayList<DepositBean.DataBean>());
                            }
                        }else{
                            depositView.showToast(depositBean.getMsg());
                        }
                    }
                });
    }
}
