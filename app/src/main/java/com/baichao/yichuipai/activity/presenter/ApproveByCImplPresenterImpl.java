package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.PApproveBean;
import com.baichao.yichuipai.activity.view.ApproveByCView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;
import com.baichao.yichuipai.utils.TimeUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/6/5.
 */

public class ApproveByCImplPresenterImpl implements ApproveByCImplPresenter{

    private Context context;
    private ApproveByCView approveByCView;

    public ApproveByCImplPresenterImpl(Context context, ApproveByCView approveByCView) {
        this.context = context;
        this.approveByCView = approveByCView;
    }

    @Override
    public void netApproveByC(ArrayList<String> list, String userId, String companyName, String licenseNo, String personName, String personPosition, String personMobile, String personEmail) {
        if(companyName.equals("")){
            approveByCView.showToast("企业名称输入不能为空");
        }else if(licenseNo.equals("")){
            approveByCView.showToast("营业执照注册号不能为空");
        }else if(personName.equals("")){
            approveByCView.showToast("姓名输入不能为空");
        }else if(personPosition.equals("")){
            approveByCView.showToast("职位输入不能为空");
        }else if(personMobile.equals("")){
            approveByCView.showToast("手机号码输入不能为空");
        }else if(personEmail.equals("")){
            approveByCView.showToast("电子邮箱输入不能为空");
        }else if(list==null || list.size()<4){
            approveByCView.showToast("上传材料不能为空");
        }else{
            NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP_PRIVATE,context).create(NetService.class);
            netService.approveCommit_c(TimeUtils.getToken(context),userId,companyName,licenseNo,
                    personName,personPosition,personMobile,personEmail,
                    list.get(0), "idcard_front",
                    list.get(1),"idcard_back",
                    list.get(2),"hand_idcard",
                    list.get(3),"bussiness_licence")
                    .subscribeOn(Schedulers.newThread())
                    .unsubscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<PApproveBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "---失败原因--" + e.getMessage());
                            approveByCView.showToast("提交失败，可能是网络原因");
                        }

                        @Override
                        public void onNext(PApproveBean pApproveBean) {
                            if(pApproveBean.getCode().equals("1")){
                                approveByCView.showToast("提交成功");
                                approveByCView.commitSucceed();
                            }else{
                                approveByCView.showToast("提交失败");
                            }
                        }
                    });
        }
    }
}
