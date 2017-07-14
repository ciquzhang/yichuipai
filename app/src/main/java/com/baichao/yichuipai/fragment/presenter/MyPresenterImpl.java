package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.AuthStatusBean;
import com.baichao.yichuipai.fragment.moudule.RefreshTokenBean;
import com.baichao.yichuipai.fragment.moudule.UserMessageBean;
import com.baichao.yichuipai.fragment.view.MyFragmentView;
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
    private MyFragmentView myFragmentView;

    public MyPresenterImpl(Context context,MyFragmentView myFragmentView) {
        this.context = context;
        this.myFragmentView = myFragmentView;
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

    @Override
    public void getAuthStatus(String userId, final int authType) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP_PRIVATE,context).create(NetService.class);
        netService.getAuthStatus(userId)
                .subscribeOn(Schedulers.newThread())//指定联网线程
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AuthStatusBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "认证接口:" + e.getMessage());
                    }

                    @Override
                    public void onNext(AuthStatusBean authStatusBean) {
                        if(authStatusBean.getCode().equals("1")){
                            if(authStatusBean.getData()!=null){
                                if(authType == Constant.AUTH_PERSON){
                                    //个人认证
                                    myFragmentView.isAuth(authStatusBean.getData().get(1).getAuthPersonStatus(),Constant.AUTH_PERSON);
                                }else if(authType == Constant.AUTH_COMPANY){
                                    //企业认证
                                    myFragmentView.isAuth(authStatusBean.getData().get(0).getAuthCompanyStatus(),Constant.AUTH_COMPANY);
                                }else{
                                    Log.e("TAG", "认证error");
                                }
                            }
                        }else{
                            myFragmentView.showToast(authStatusBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForMessage(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_DEPOSIT,context).create(NetService.class);
        netService.getUserMessage(userId)
                .subscribeOn(Schedulers.newThread())//指定联网线程
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserMessageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage() + "1111");
                    }

                    @Override
                    public void onNext(UserMessageBean userMessageBean) {
                        if(userMessageBean.getCode().equals("1")){
                            myFragmentView.setUserMessage(userMessageBean.getData().getPersonAuth().getAuthPersonStatus(),
                                    userMessageBean.getData().getCompanyAuth().getAuthCompanyStatus(),
                                    userMessageBean.getData().getUser().getNickname(),userMessageBean.getData().getUser().getHeadImg()
                                    );
                        }else{
                            myFragmentView.showToast(userMessageBean.getMsg());
                        }
                    }
                });
    }
}
