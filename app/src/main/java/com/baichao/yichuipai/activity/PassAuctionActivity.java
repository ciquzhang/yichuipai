package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.PassAuctionListBean;
import com.baichao.yichuipai.activity.presenter.PassAuctionPresenter;
import com.baichao.yichuipai.activity.presenter.PassAuctionPresenterImpl;
import com.baichao.yichuipai.activity.view.PassAuctionView;
import com.baichao.yichuipai.adapter.PassAuctionHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityPassAuctionBinding;
import com.baichao.yichuipai.utils.ACache;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class PassAuctionActivity extends BaseActivity implements PassAuctionView ,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private ActivityPassAuctionBinding binding;
    private PassAuctionPresenter presenter;
    private RecyclerArrayAdapter<PassAuctionListBean.DataBean.PageDataBean> adapter;
    private Handler handler = new Handler();
    private int num = 1;
    private ArrayList<PassAuctionListBean.DataBean.PageDataBean> mData;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pass_auction);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new PassAuctionPresenterImpl(mContext,this);
        mData = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.passRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),10, 0,0);
        itemDecoration.setDrawLastItem(false);
        binding.passRecycler.addItemDecoration(itemDecoration);
        binding.passRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<PassAuctionListBean.DataBean.PageDataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new PassAuctionHolder(viewGroup,mContext);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        binding.passRecycler.setRefreshListener(this);
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
        binding.passAuctionReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //判断该进入直播还是非直播
                if(mData.get(position).getAuctionInfo().getLiveStatus() == 1){
                    //直播
                    Intent intent =  new Intent(mContext,LiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId()+"");
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId()+"");
                    Log.e("TAG", "--直播houseId--" + mData.get(position).getHouseInfo().getId()+"" + "auctionId" +
                            mData.get(position).getAuctionInfo().getId() + "userId" + ACache.get(mContext).getAsString("userId"));
                    startActivity(intent);
                }else{
                    //非直播
                    Intent intent =  new Intent(mContext,NoLiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId()+"");
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId()+"");
                    Log.e("TAG", "--非直播houseId--" + mData.get(position).getHouseInfo().getId()+"" + "auctionId" +
                            mData.get(position).getAuctionInfo().getId() + "userId" + ACache.get(mContext).getAsString("userId"));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadSuccessful(List<PassAuctionListBean.DataBean.PageDataBean> list) {
        if(list.size()>0){
            mData.addAll(list);
            adapter.addAll(list);
        } else {
            adapter.addAll(list);
        }
    }

    @Override
    public void refreshSuccessful(List<PassAuctionListBean.DataBean.PageDataBean> list) {
        if(list.size() == 0){
            binding.passRecycler.showEmpty();
            return;
        }
        mData.clear();
        adapter.clear();

        mData.addAll(list);
        adapter.addAll(list);
    }

    @Override
    public void onRefresh() {
        num = 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                presenter.netForList();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForMoreList(++num);
            }
        }, 2000);
    }
}
