package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.BuyListBean;
import com.baichao.yichuipai.activity.presenter.BuyListPresenter;
import com.baichao.yichuipai.activity.presenter.BuyListPresenterImpl;
import com.baichao.yichuipai.activity.view.BuyListView;
import com.baichao.yichuipai.adapter.BuyListHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityBuyListBinding;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class BuyListActivity extends BaseActivity implements BuyListView,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private ActivityBuyListBinding binding;
    private BuyListPresenter presenter;
    private RecyclerArrayAdapter<BuyListBean.DataBean.PageDataBean> adapter;
    private Handler handler = new Handler();
    private List<BuyListBean.DataBean.PageDataBean> mData;
    private int num = 1;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_buy_list);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        mData = new ArrayList<>();
        presenter = new BuyListPresenterImpl(mContext,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.buyListRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),10, 0,0);
        itemDecoration.setDrawLastItem(false);
        binding.buyListRecycler.addItemDecoration(itemDecoration);
        binding.buyListRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<BuyListBean.DataBean.PageDataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new BuyListHolder(viewGroup,mContext);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        binding.buyListRecycler.setRefreshListener(this);
        onRefresh();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();

        /**
         * 返回
         */
        binding.buyListReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSuccess(List<BuyListBean.DataBean.PageDataBean> data) {
        if(data.size() == 0){
            binding.buyListRecycler.showEmpty();
            return;
        }
        for(int i = 0;i<data.size();i++){
            data.get(i).setPosition(i);
        }

        mData.clear();
        adapter.clear();

        mData.addAll(data);
        adapter.addAll(data);
    }

    @Override
    public void loadMoreSuccess(List<BuyListBean.DataBean.PageDataBean> data) {
        if(data.size()>0){
            mData.addAll(data);
            adapter.addAll(data);
            for (int i =0;i<mData.size();i++){
                mData.get(i).setPosition(i);
            }
        } else {
            adapter.addAll(data);
        }
    }

    @Override
    public void onRefresh() {
        num = 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                presenter.netForList(getIntent().getStringExtra("auctionId"));
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForMoreList(getIntent().getStringExtra("auctionId"),++num);
            }
        }, 2000);
    }
}
