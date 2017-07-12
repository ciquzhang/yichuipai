package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.RefreshTokenBean;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/6/5.
 */

public class MyPresenterImpl implements MyPresenter{

    private Context context;

    public MyPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void refreshToken(String token) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP,context).create(NetService.class);
        netService.refreshToken(token)
                .subscribeOn(Schedulers.newThread())//指定联网线程
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RefreshTokenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RefreshTokenBean refreshTokenBean) {
                        if(refreshTokenBean.getCode().equals("1")){
                            //刷新token
                            ACache.get(context).put("token_past_time",refreshTokenBean.getData().getExpire_time());
                            ACache.get(context).put("token",refreshTokenBean.getData().getAccess_token());
                            Log.e("TAG", "刷新token成功");
                        }else{
                            Log.e("TAG", "刷新token失败");
                        }
                    }
                });
    }
}
