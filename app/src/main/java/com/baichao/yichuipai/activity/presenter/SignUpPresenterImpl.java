package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.NeedDepositBean;
import com.baichao.yichuipai.activity.module.SignBean;
import com.baichao.yichuipai.activity.view.SignUpView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/29.
 */

public class SignUpPresenterImpl implements SignUpPresenter {

    private Context context;
    private SignUpView signUpView;

    public SignUpPresenterImpl(Context context, SignUpView signUpView) {
        this.context = context;
        this.signUpView = signUpView;
    }

    @Override
    public void netForSignUp(String userId, String auctionId, String realName, String nationalId,
                             String region, String street, String depositId) {
        if(realName.equals("")){
            signUpView.showToast("姓名输入不能为空");
            return;
        }
        if (nationalId.equals("")){
            signUpView.showToast("身份证号输入不能为空");
            return;
        }
        if(region.equals("请选择所在地区")) {
            signUpView.showToast("请选择所在地区");
            return;
        }
        if(street.equals("")){
            signUpView.showToast("所在街道不能为空");
            return;
        }
        if(depositId.equals("-1")) {
            signUpView.showToast("押金选择不能为空");
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.signRecord(userId,auctionId,realName,nationalId,region,street,depositId)
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
                        if(signBean.getCode().equals("1")){
                            signUpView.showToast("报名成功");
                            Log.e("TAG", "报名状态" + signBean.getMsg());
                            signUpView.signSuccess();
                        }else{
                            signUpView.showToast(signBean.getMsg());
                        }
                    }
                });

    }

    @Override
    public void netForDeposit(String userId, String regionId, String amount) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECTION,context).create(NetService.class);
        netService.getNeedDepositList(userId,regionId,amount)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NeedDepositBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(NeedDepositBean needDepositBean) {
                        if(needDepositBean.getCode().equals("1")){
                            if(needDepositBean.getData()!=null){
                                signUpView.depositSuccess(needDepositBean.getData());
                            }else{
                                signUpView.depositSuccess(new ArrayList<NeedDepositBean.DataBean>());
                            }
                        }else{
                            signUpView.showToast(needDepositBean.getMsg());
                        }
                    }
                });
    }
}
