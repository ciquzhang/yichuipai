package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.CollectionListBean;
import com.baichao.yichuipai.fragment.moudule.HousePvBean;
import com.baichao.yichuipai.fragment.view.AuCollectView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/3.
 */

public class AuCollectPresenterImpl implements AuCollectPresenter {

    private Context context;
    private AuCollectView collectView;
    private int navCount;

    public AuCollectPresenterImpl(Context context, AuCollectView collectView) {
        this.context = context;
        this.collectView = collectView;
    }

    @Override
    public void netForList(String userId) {
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getCollectList(userId)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CollectionListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onNext(CollectionListBean collectionListBean) {
                        if(collectionListBean.getCode().equals("1")){
                            if(collectionListBean.getData()!=null){
                                navCount = collectionListBean.getData().getNavCount();
                                collectView.refreshSuccessful(collectionListBean.getData().getPageData());
                            }else{
                                collectView.refreshSuccessful(new ArrayList<CollectionListBean.DataBean.PageDataBean>());
                            }
                        }else{
                            collectView.showToast(collectionListBean.getMsg());
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
            collectView.loadMoreSuccessful(new ArrayList<CollectionListBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_COLLECT_LIST,context).create(NetService.class);
        netService.getCollectList(userId,pageNum+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CollectionListBean>(){
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onNext(CollectionListBean collectionListBean) {
                        if(collectionListBean.getCode().equals("1")){
                            navCount = collectionListBean.getData().getNavCount();
                            collectView.loadMoreSuccessful(collectionListBean.getData().getPageData());
                        }else{
                            collectView.showToast(collectionListBean.getMsg());
                        }
                    }
                });
    }
}
