package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.LoginBean;
import com.baichao.yichuipai.activity.view.LoginView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/5/8.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private Context context;

    public LoginPresenterImpl(LoginView loginView,Context context) {
        this.loginView = loginView;
        this.context = context;
    }

    @Override
    public void loginCommit(String phone, String password) {
        //提交登录
        if(phone.equals("")){
            loginView.showToast("号码输入不能为空");
        }else if(password.equals("")){
            loginView.showToast("密码输入不能为空");
        }else{
            NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP,context).create(NetService.class);
            netService.loginCommit(phone, password)
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<LoginBean>(){
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "登录" + e.getMessage());
                        }

                        @Override
                        public void onNext(LoginBean loginBean) {
                            if(loginBean.getCode().equals("1")){
                                //登录成功
                                ACache.get(context).put("token",loginBean.getData().getUserToken().getAccess_token());
                                ACache.get(context).put("token_past_time",loginBean.getData().getUserToken().getExpire_time());
                                ACache.get(context).put("userId",loginBean.getData().getId()+"");
                                loginView.showToast("登录成功");
                                loginView.loginSuccessful();
                            }else{
                                loginView.showToast("登录失败");
                            }
                        }
                    });
        }
    }
}
