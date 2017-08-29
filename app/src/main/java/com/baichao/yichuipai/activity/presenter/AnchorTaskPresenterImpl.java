package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.AnchorTaskBean;
import com.baichao.yichuipai.activity.view.AnchorTaskView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/24.
 */

public class AnchorTaskPresenterImpl implements AnchorTaskPresenter {
    private Context context;
    private AnchorTaskView anchorTaskView;

    public AnchorTaskPresenterImpl(Context context, AnchorTaskView anchorTaskView) {
        this.context = context;
        this.anchorTaskView = anchorTaskView;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_ANCHOR,context).create(NetService.class);
        netService.getAnchorList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AnchorTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "获取主播任务列表" + e.getMessage());
                    }

                    @Override
                    public void onNext(AnchorTaskBean anchorTaskBean) {
                        if(anchorTaskBean.getCode().equals("1")){
                            if(anchorTaskBean.getData()!=null){
                                anchorTaskView.getListSuccess(anchorTaskBean.getData());
                            }else{
                                anchorTaskView.getListNull();
                                Log.e("TAG", "获取主播任务列表为空：" + anchorTaskBean.getMsg());
                            }
                        }else{
                            Log.e("TAG", "获取主播任务列表失败：" + anchorTaskBean.getMsg());
                        }
                    }
                });
    }
}
