package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.activity.presenter.NoLivePresenter;
import com.baichao.yichuipai.activity.presenter.NoLivePresenterImpl;
import com.baichao.yichuipai.activity.view.NoLiveView;
import com.baichao.yichuipai.adapter.LiveAdapter;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityNoLiveBinding;
import com.baichao.yichuipai.fragment.ImageOrTextFragment;
import com.baichao.yichuipai.fragment.Live1Fragment;
import com.baichao.yichuipai.fragment.PastVideoFragment;
import com.my.view.switchanimotion.DepthPageTransformer;

import java.util.ArrayList;

public class NoLiveActivity extends BaseActivity implements NoLiveView {

    private ActivityNoLiveBinding binding;
    private LiveAdapter adapter;
    private NoLivePresenter presenter;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_no_live);
    }

    @Override
    protected void initViews(Bundle savedInstanceState){
        super.initViews(savedInstanceState);
        presenter = new NoLivePresenterImpl(mContext,this);
    }

    private void tabSetting(HouseInfoDetailBean.DataBean dataBean,String houseId,String auctionId,int live_type) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("基本信息");
        titles.add("图文信息");
        titles.add("往期视频");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Live1Fragment(live_type,dataBean,houseId,auctionId));
        fragments.add(new ImageOrTextFragment());
        fragments.add(new PastVideoFragment());
        adapter = new LiveAdapter(getSupportFragmentManager(),mContext,fragments,titles);
        binding.noLiveVp.setAdapter(adapter);
        binding.noLiveVp.setOffscreenPageLimit(2);
        binding.noLiveTab.setTabGravity(TabLayout.GRAVITY_FILL);
        binding.noLiveTab.setTabMode(TabLayout.MODE_FIXED);
        binding.noLiveTab.setupWithViewPager(binding.noLiveVp);
        /**
         * 轮播图设置
         */
        binding.noLiveFv.setViewPagerSwitchStyle(new DepthPageTransformer());//设置轮播动画效果
        binding.noLiveFv.setViewPagerSwitchSpeed(200);//切换动画的持续时间
        binding.noLiveFv.setIndicationPointState(true);//显示指示点
        binding.noLiveFv.setAutoPlayState(true);//开启自动播放
        binding.noLiveFv.setInfiniteLoopState(true);//开启无线循环
        ArrayList<String> url = new ArrayList<>();
        url.add("http://note.youdao.com/yws/public/resource/e2696df7da22a9ccf89cbc370354d265/xmlnote/WEBRESOURCEfb8e27f06b89bdefbda1177c0bde7243/150");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493894303238&di=dd600d8eda014ed5ecf041a6b7261090&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F92%2Fd%2F173.jpg");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493894322211&di=dcf32b088e93c110479022917b287fb8&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2FArticle%2FUploadFiles%2F201411%2F20141116135722282.jpg");
        binding.noLiveFv.setURL(url);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.netForItemList(getIntent().getStringExtra("houseId"),getIntent().getStringExtra("auctionId"));
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(NoLiveActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void netForItemsSuccess(HouseInfoDetailBean.DataBean dataBean, String houseId, String auctionId) {
        //未直播
        int live_type = 0;
        if(dataBean.getAuctionMeeting().getSignStatus() == 2 && dataBean.getAuctionInfo().getAuctionStatus() == 2){
            //拍卖
            live_type = 1;
        }else if(dataBean.getAuctionMeeting().getSignStatus() == 1 && dataBean.getAuctionInfo().getAuctionStatus() == 0){
            //可报名
            live_type = 4;
        }else if(dataBean.getAuctionMeeting().getSignStatus() == 0 && dataBean.getAuctionInfo().getAuctionStatus() == 0){
            //不可报名
            live_type = 5;
        }else if(dataBean.getAuctionMeeting().getSignStatus() == 2 && dataBean.getAuctionInfo().getAuctionStatus() == 0){
            //报名结束
            live_type = 5;
        }else if(dataBean.getAuctionInfo().getAuctionStatus() == 3 || dataBean.getAuctionInfo().getAuctionStatus() == 4){
            live_type = 5;
        }
        tabSetting(dataBean,houseId,auctionId,live_type);
    }
}
