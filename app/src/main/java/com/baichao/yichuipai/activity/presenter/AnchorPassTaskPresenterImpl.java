package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.activity.module.AnchorPassTaskBean;
import com.baichao.yichuipai.activity.view.AnchorPassTaskView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/25.
 */

public class AnchorPassTaskPresenterImpl implements AnchorPassTaskPresenter {

    private Context context;
    private AnchorPassTaskView anchorPassTaskView;
    private int navCount;

    public AnchorPassTaskPresenterImpl(Context context, AnchorPassTaskView anchorPassTaskView) {
        this.context = context;
        this.anchorPassTaskView = anchorPassTaskView;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_ANCHOR,context).create(NetService.class);
        netService.getPassAnchorList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AnchorPassTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "获取往期主播任务列表" + e.getMessage());
                    }

                    @Override
                    public void onNext(AnchorPassTaskBean anchorPassTaskBean) {
                        if(anchorPassTaskBean.getCode().equals("1")){
                            if(anchorPassTaskBean.getData()!=null) {
                                navCount = anchorPassTaskBean.getData().getNavCount();
                                anchorPassTaskView.refreshSuccessful(anchorPassTaskBean.getData().getPageData());
                            }else{
                                anchorPassTaskView.refreshSuccessful(new ArrayList<AnchorPassTaskBean.DataBean.PageDataBean>());
                            }
                        }else{
                            Log.e("TAG", "获取往期主播任务列表失败" + anchorPassTaskBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void netForList(String userId, int pageNum) {
        if(pageNum > navCount){
            anchorPassTaskView.loadMoreSuccessful(new ArrayList<AnchorPassTaskBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_ANCHOR,context).create(NetService.class);
        netService.getPassAnchorList(userId,pageNum + "")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AnchorPassTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "获取往期主播任务列表" + e.getMessage());
                    }

                    @Override
                    public void onNext(AnchorPassTaskBean anchorPassTaskBean) {
                        if(anchorPassTaskBean.getCode().equals("1")){
                            if(anchorPassTaskBean.getData()!=null) {
                                navCount = anchorPassTaskBean.getData().getNavCount();
                                anchorPassTaskView.loadMoreSuccessful(anchorPassTaskBean.getData().getPageData());
                            }else{
                                anchorPassTaskView.loadMoreSuccessful(new ArrayList<AnchorPassTaskBean.DataBean.PageDataBean>());
                            }
                        }else{
                            Log.e("TAG", "获取往期主播更多任务列表失败" + anchorPassTaskBean.getMsg());
                        }
                    }
                });
    }
}
