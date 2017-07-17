package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.HousePvBean;
import com.baichao.yichuipai.fragment.moudule.TakenListBean;
import com.baichao.yichuipai.fragment.view.AuTakenView;
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

public class AuTakenPresenterImpl implements AuTakenPresenter {

    private Context context;
    private AuTakenView auTakenView;
    private int navCount;

    public AuTakenPresenterImpl(Context context, AuTakenView auTakenView) {
        this.context = context;
        this.auTakenView = auTakenView;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getResultList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TakenListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(TakenListBean takenListBean) {
                        if(takenListBean.getCode().equals("1")){
                            if(takenListBean.getData()!=null){
                                navCount = takenListBean.getData().getNavCount();
                                auTakenView.refreshSuccessful(takenListBean.getData().getPageData());
                            }else{
                                auTakenView.refreshSuccessful(new ArrayList<TakenListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            auTakenView.showToast(takenListBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void addPv(String houseId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getHousePv(houseId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HousePvBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "房屋点击量" + e.getMessage());
                    }

                    @Override
                    public void onNext(HousePvBean housePvBean) {
                        if(housePvBean.getCode().equals("1")){
                            Log.e("TAG", "房屋点击量接口成功调用");
                        }else{
                            Log.e("TAG", "房屋点击量接口调用失败");
                        }
                    }
                });
    }

    @Override
    public void netForMoreList(String userId, int pageNum) {
        if(pageNum > navCount){
            auTakenView.loadMoreSuccessful(new ArrayList<TakenListBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getResultList(userId,pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TakenListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(TakenListBean takenListBean) {
                        if(takenListBean.getCode().equals("1")){
                            if(takenListBean.getData()!=null){
                                navCount = takenListBean.getData().getNavCount();
                                auTakenView.loadMoreSuccessful(takenListBean.getData().getPageData());
                            }else{
                                auTakenView.loadMoreSuccessful(new ArrayList<TakenListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            auTakenView.showToast(takenListBean.getMsg());
                        }
                    }
                });
    }
}
