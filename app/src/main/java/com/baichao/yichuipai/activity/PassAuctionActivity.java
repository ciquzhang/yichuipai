package com.baichao.yichuipai.activity;

import android.content.Intent;
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
import com.baichao.yichuipai.activity.module.PassAuctionListBean;
import com.baichao.yichuipai.activity.presenter.PassAuctionPresenter;
import com.baichao.yichuipai.activity.presenter.PassAuctionPresenterImpl;
import com.baichao.yichuipai.activity.view.PassAuctionView;
import com.baichao.yichuipai.adapter.PassAuctionHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityPassAuctionBinding;
import com.baichao.yichuipai.utils.Constant;
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
                if(mData.get(position).getAuctionInfo().getLiveStatus() == 1){
                    //直播中
                    Intent intent =  new Intent(mContext,LiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId());
                    //设置 1: 拍卖中  2:看房中：3 :看房（不能报名）
                    if(mData.get(position).getHouseInfo().getSeeHouseStatus() == 1 &&
                            mData.get(position).getAuctionInfo().getSignStatus() == 0 &&
                            mData.get(position).getAuctionInfo().getAuctionStatus()!=2){
                        //看房中不能报名
                        intent.putExtra("live_type",3);
                    }else if(mData.get(position).getHouseInfo().getSeeHouseStatus() == 1 &&
                            mData.get(position).getAuctionInfo().getSignStatus() == 1 &&
                            mData.get(position).getAuctionInfo().getAuctionStatus()==0){
                        //看房中可以报名
                        intent.putExtra("live_type",2);
                    }else{
                        //拍卖中
                        intent.putExtra("live_type",1);
                    }
//                    Log.e("TAG", "getHouseId:" + mData.get(position).getAuctionInfo().getHouseId() +
//                            "getAuctionId" + mData.get(position).getAuctionRecord().getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
                }else{
                    //未直播
                    Intent intent =  new Intent(mContext,NoLiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getAuctionInfo().getHouseId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionRecord().getAuctionId());
                    if(mData.get(position).getAuctionInfo().getAuctionStatus() == 2 && mData.get(position).getAuctionInfo().getSignStatus() == 0){
                        //拍卖中
                        intent.putExtra("live_type",1);
                    }
                    if(mData.get(position).getAuctionInfo().getAuctionStatus() != 2 && mData.get(position).getAuctionInfo().getSignStatus() == 1){
                        //报名中 -->未开始直播,可以报名
                        intent.putExtra("live_type",4);
                    }else if(mData.get(position).getAuctionInfo().getAuctionStatus() != 2 && mData.get(position).getAuctionInfo().getSignStatus() == 0){
                        //停止报名 --> 未开始直播，不能报名
                        intent.putExtra("live_type",5);
                    }
//                    Log.e("TAG", "getHouseId:" + mData.get(position).getAuctionInfo().getHouseId() +
//                            "getAuctionId" + mData.get(position).getAuctionRecord().getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
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
