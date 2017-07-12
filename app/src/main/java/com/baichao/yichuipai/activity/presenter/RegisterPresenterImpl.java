package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.CheckIsRegister;
import com.baichao.yichuipai.activity.module.RegisterBean;
import com.baichao.yichuipai.activity.module.RegisterCodeBean;
import com.baichao.yichuipai.activity.view.RegisterView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.PhoneFormatCheckUtils;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/5/8.
 */

public class RegisterPresenterImpl implements RegisterLoadPresenter {

    private RegisterView registerView;
    private Context context;

    public RegisterPresenterImpl(RegisterView registerView, Context context) {
        this.registerView = registerView;
        this.context = context;
    }

    @Override
    public void registerGetCode(final String phone) {
        if(!PhoneFormatCheckUtils.isPhoneLegal(phone)) {
            registerView.showToast("请输入正确的手机号码");
            return;
        }else{
            final NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP,context).create(NetService.class);
            netService.checkPhone(phone)
                    .subscribeOn(Schedulers.newThread())//指定联网线程
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<CheckIsRegister>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            registerView.showToast("获取验证码失败,可能是网络原因");
                        }

                        @Override
                        public void onNext(CheckIsRegister checkIsRegister) {
                            if(checkIsRegister.getCode().equals("1")){
                                //可以注册
                                netService.getCodeByRegister(phone)
                                        .subscribeOn(Schedulers.newThread())//指定联网线程
                                        .unsubscribeOn(Schedulers.newThread())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Subscriber<RegisterCodeBean>() {
                                            @Override
                                            public void onCompleted() {
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                registerView.showToast("获取失败,可能是网络原因");
                                            }

                                            @Override
                                            public void onNext(RegisterCodeBean registerCodeBean) {
                                                if(registerCodeBean.getCode().equals("1")){
                                                    registerView.showToast(registerCodeBean.getMsg());
                                                }
                                            }
                                        });
                            }else {
//                                registerView.showToast(checkIsRegister.getErrors().getMobile());
                            }
                        }
                    });
        }
    }

    /**
     * 注册
     * @param phone
     * @param code
     * @param password
     */
    @Override
    public void registerCommit(String phone, String code, String password) {
        if(phone.equals("") || code.equals("") || password.equals("")){
            registerView.showToast("输入不能为空哦");
            return;
        }else if(!PhoneFormatCheckUtils.isPhoneLegal(phone)){
            registerView.showToast("请输入正确的手机号码");
            return;
        }else{
            //提交注册
            NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP,context).create(NetService.class);
            netService.registerCommit(phone,password,code)
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<RegisterBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "-----" + e.getMessage());
                            registerView.showToast("注册失败,可能是网络原因");
                        }

                        @Override
                        public void onNext(RegisterBean registerBean){
                            if(registerBean.getCode().equals("1")){
                                //成功
                                registerView.showToast("注册成功");
                                registerView.finishView();
                            }else{
                                //失败
                                registerView.showToast("注册失败");
                            }
                        }
                    });
        }
    }
}
