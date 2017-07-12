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
import com.baichao.yichuipai.databinding.ActivityLiveBinding;
import com.baichao.yichuipai.fragment.Live1Fragment;

import java.util.ArrayList;

public class LiveActivity extends BaseActivity implements NoLiveView {

    private ActivityLiveBinding binding;
    private LiveAdapter adapter;
    private NoLivePresenter presenter;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new NoLivePresenterImpl(mContext,this);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.netForData(getIntent().getIntExtra("houseId",0)+"",
                getIntent().getIntExtra("auctionId" , 0)+"");
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    public void netSuccess(HouseInfoDetailBean.DataBean dataBean,String houseId, String auctionId) {
        tabSetting(dataBean,houseId,auctionId);//基本设置
    }

    private void tabSetting(HouseInfoDetailBean.DataBean dataBean,String houseId, String auctionId) {
        int live_type = getIntent().getIntExtra("live_type",0);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("基本信息");
        titles.add("图文信息");
        titles.add("往期视频");
        titles.add("聊天室");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Live1Fragment(live_type,dataBean,houseId,auctionId));
        fragments.add(new Live1Fragment(live_type,dataBean,houseId,auctionId));
        fragments.add(new Live1Fragment(live_type,dataBean,houseId,auctionId));
        fragments.add(new Live1Fragment(live_type,dataBean,houseId,auctionId));
        adapter = new LiveAdapter(getSupportFragmentManager(),mContext,fragments,titles);
        binding.liveVp.setAdapter(adapter);
        binding.liveVp.setOffscreenPageLimit(2);
        binding.liveTab.setTabGravity(TabLayout.GRAVITY_FILL);
        binding.liveTab.setTabMode(TabLayout.MODE_FIXED);
        binding.liveTab.setupWithViewPager(binding.liveVp);
//        presenter.setIndicator(binding.liveTab,10,10);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
