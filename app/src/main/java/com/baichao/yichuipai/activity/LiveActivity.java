package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
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
        presenter.netForItemList(getIntent().getStringExtra("houseId"),getIntent().getStringExtra("auctionId"));
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    private void tabSetting(HouseInfoDetailBean.DataBean dataBean,String houseId, String auctionId,int live_type) {
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
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void netForItemsSuccess(HouseInfoDetailBean.DataBean dataBean, String houseId, String auctionId) {
        int live_type = 0;
        Log.e("TAG", "getSignStatus" + dataBean.getAuctionMeeting().getSignStatus());
        Log.e("TAG", "getAuctionStatus" + dataBean.getAuctionInfo().getAuctionStatus());
        Log.e("TAG", "getSignStatus" + dataBean.getHouseInfo().getSeeHouseStatus());
        if(dataBean.getAuctionMeeting().getSignStatus() == 1 && dataBean.getAuctionInfo().getAuctionStatus() == 0 &&
                dataBean.getHouseInfo().getSeeHouseStatus() == 1){
            //看房并且可以报名
            live_type = 2;
        }else if(dataBean.getAuctionMeeting().getSignStatus() == 0 && dataBean.getAuctionInfo().getAuctionStatus() == 0 &&
                dataBean.getHouseInfo().getSeeHouseStatus() == 1){
            //看房不可报名
            live_type = 3;
        }else if(dataBean.getAuctionMeeting().getSignStatus() == 2 && dataBean.getAuctionInfo().getAuctionStatus() == 2){
            //拍卖中
            live_type = 1;
        }
        tabSetting(dataBean,houseId,auctionId,live_type);
    }
}
