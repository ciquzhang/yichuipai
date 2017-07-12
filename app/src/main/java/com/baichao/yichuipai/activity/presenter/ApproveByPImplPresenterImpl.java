package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.PApproveBean;
import com.baichao.yichuipai.activity.view.ApproveByPView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;
import com.baichao.yichuipai.utils.TimeUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/5/16.
 */

public class ApproveByPImplPresenterImpl implements ApproveByPImplPresenter{
    private Context context;
    private ApproveByPView approveByPView;

    public ApproveByPImplPresenterImpl(Context context, ApproveByPView approveByPView) {
        this.context = context;
        this.approveByPView = approveByPView;
    }

    @Override
    public void netApproveByP(ArrayList<String> list, String realName, String idNo) {
        if(realName.equals("")){
            approveByPView.showToast("姓名输入不能为空");
        }else if(idNo.equals("")){
            approveByPView.showToast("身份证号输入不能为空");
        }else if(list == null && list.size() < 3){
            approveByPView.showToast("上传证明材料不能为空");
        }else{
            NetService netService = RetrofitUtils.getRetrofit(Constant.NET_APP_PRIVATE,context).create(NetService.class);
            netService.approveCommit_p(TimeUtils.getToken(context),realName,idNo,TimeUtils.getId(context),
                    list.get(0), "idcard_front",
                    list.get(1),"idcard_back",
                    list.get(2),"hand_idcard")
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
                            approveByPView.showToast("提交失败，可能是网络原因");
                        }

                        @Override
                        public void onNext(PApproveBean pApproveBean) {
                            if(pApproveBean.getCode().equals("1")){
                                approveByPView.showToast("提交成功");
                                approveByPView.commitSucceed();
                            }else{
                                approveByPView.showToast(pApproveBean.getMsg());
                            }
                        }
                    });
        }
    }
}
