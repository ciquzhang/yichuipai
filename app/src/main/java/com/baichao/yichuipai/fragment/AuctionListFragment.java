package com.baichao.yichuipai.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.adapter.AuctionAdapter;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.databinding.FragAuctionListBinding;
import com.baichao.yichuipai.fragment.view.AuctionListView;
import com.baichao.yichuipai.utils.Constant;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pll on 2017/5/23.
 */

public class AuctionListFragment extends BaseFragment implements AuctionListView {

    private FragAuctionListBinding binding;
    private List<String> mDataList = Arrays.asList(Constant.CHANNELS);
    private AuctionAdapter mAuctionAdapter;
    /**
     * 是否创建
     */
    protected boolean isCreate = false;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_auction_list, container, false);
        isCreate = true;
        return binding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        /**
         * 设置顶部样式
         */
        baseSetting();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreate) {
            //相当于Fragment的onResume
            //在这里处理加载数据等操作
            baseSetting();
            initData();
        } else {
            //相当于Fragment的onPause
        }
    }

    /**
     * 界面基础设置
     */
    private void baseSetting(){
        binding.fragAuctionTab.setBackgroundResource(R.drawable.frag_tab_shape);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setPadding(72,0,72,0);
                clipPagerTitleView.setText(mDataList.get(index));
                clipPagerTitleView.setTextColor(Color.parseColor("#ffffff"));
                clipPagerTitleView.setClipColor(Color.parseColor("#00b589"));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.fragAuctionViewpager.setCurrentItem(index);
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                float navigatorHeight = context.getResources().getDimension(R.dimen.common_navigator_height);
                float borderWidth = UIUtil.dip2px(context, 1);
                float lineHeight = navigatorHeight - 2 * borderWidth;
                indicator.setLineHeight(lineHeight);
                indicator.setRoundRadius(8);
                indicator.setColors(Color.parseColor("#ffffff"));
                return indicator;
            }
        });
        binding.fragAuctionTab.setNavigator(commonNavigator);
        ViewPagerHelper.bind(binding.fragAuctionTab, binding.fragAuctionViewpager);
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new AuCollectFragment());
        list.add(new AuAppliedFragment());
        list.add(new AuTakenFragment());
        mAuctionAdapter = new AuctionAdapter(getActivity().getSupportFragmentManager(),list);
        binding.fragAuctionViewpager.setAdapter(mAuctionAdapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }
}
