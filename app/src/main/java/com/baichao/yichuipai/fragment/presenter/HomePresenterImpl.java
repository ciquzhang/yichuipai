package com.baichao.yichuipai.fragment.presenter;

import android.content.Context;
import android.util.Log;

import com.baichao.yichuipai.fragment.moudule.HomeBean;
import com.baichao.yichuipai.fragment.moudule.HousePvBean;
import com.baichao.yichuipai.fragment.view.HomeView;
import com.baichao.yichuipai.network.NetService;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.RetrofitUtils;
import com.my.view.CarouselFigureView;
import com.my.view.switchanimotion.DepthPageTransformer;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pll on 2017/5/3.
 */

public class HomePresenterImpl implements HomePresenter{
    private HomeView homeView;
    private Context context;
    private int navCount;

    public HomePresenterImpl(HomeView homeView , Context context) {
        this.homeView = homeView;
        this.context = context;
    }

    @Override
    public void netForHomeList() {
        //获取数据成功后回调
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getHouseList()
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "获取房屋列表 : " + e.getMessage());
                        homeView.showToast("获取失败,可能是网络原因");
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        if(homeBean.getCode().equals("1")){
                            navCount = homeBean.getData().getNavCount();
                            if(homeBean.getData().getPageData()!=null){
                                homeView.refreshSuccessful(homeBean.getData().getPageData());
                            }else{
                                homeView.refreshSuccessful(new ArrayList<HomeBean.DataBean.PageDataBean>());
                            }
                        }else{
                            homeView.showToast("获取数据失败");
                        }
                    }
                });
    }

    @Override
    public void netForHomeListMore(int num) {
//        Log.e("TAG", "num:" + num + "---navCount:" + navCount);
        if(num > navCount){
            homeView.loadSuccessful(new ArrayList<HomeBean.DataBean.PageDataBean>());
            return;
        }
        NetService netService = RetrofitUtils.getRetrofit(Constant.NET_HOUSE,context).create(NetService.class);
        netService.getHouseList(num+"")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "获取房屋列表 : " + e.getMessage());
                        homeView.showToast("获取失败,可能是网络原因");
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        if(homeBean.getCode().equals("1")){
                            homeView.loadSuccessful(homeBean.getData().getPageData());
                        }else{
                            homeView.showToast("获取数据失败");
                        }
                    }
                });
    }

    @Override
    public void headLoading(CarouselFigureView carouselFigureView) {
        carouselFigureView.setViewPagerSwitchStyle(new DepthPageTransformer());//设置轮播动画效果
        carouselFigureView.setViewPagerSwitchSpeed(200);//切换动画的持续时间
        carouselFigureView.setIndicationPointState(true);//显示指示点
        carouselFigureView.setAutoPlayState(true);//开启自动播放
        carouselFigureView.setInfiniteLoopState(true);//开启无线循环
        ArrayList<String> url = new ArrayList<>();
        url.add("http://note.youdao.com/yws/public/resource/e2696df7da22a9ccf89cbc370354d265/xmlnote/WEBRESOURCEfb8e27f06b89bdefbda1177c0bde7243/150");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493894303238&di=dd600d8eda014ed5ecf041a6b7261090&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F92%2Fd%2F173.jpg");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493894322211&di=dcf32b088e93c110479022917b287fb8&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2FArticle%2FUploadFiles%2F201411%2F20141116135722282.jpg");
        carouselFigureView.setURL(url);
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
}
