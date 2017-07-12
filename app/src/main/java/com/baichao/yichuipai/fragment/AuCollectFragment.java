package com.baichao.yichuipai.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.LiveActivity;
import com.baichao.yichuipai.activity.NoLiveActivity;
import com.baichao.yichuipai.adapter.CollectionHolder;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.fragment.moudule.CollectionListBean;
import com.baichao.yichuipai.fragment.presenter.AuCollectPresenter;
import com.baichao.yichuipai.fragment.presenter.AuCollectPresenterImpl;
import com.baichao.yichuipai.fragment.view.AuCollectView;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pll on 2017/5/24.
 */

public class AuCollectFragment extends BaseFragment implements AuCollectView,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private EasyRecyclerView recyclerView;
    private AuCollectPresenter presenter;
    private RecyclerArrayAdapter<CollectionListBean.DataBean.PageDataBean> adapter;
    private List<CollectionListBean.DataBean.PageDataBean> mData;
    private Handler handler = new Handler();
    private int num = 1;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(mActivity,R.layout.auction_collext,null);
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.collect_recycler);
        return view;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        mData = new ArrayList<>();
        presenter = new AuCollectPresenterImpl(mActivity,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),20, 0,0);
        itemDecoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<CollectionListBean.DataBean.PageDataBean>(mActivity) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new CollectionHolder(viewGroup,mActivity);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        recyclerView.setRefreshListener(this);
        onRefresh();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(mData.get(position).getAuctionInfo().getLiveStatus() == 1){
                    //直播中
                    Intent intent =  new Intent(mActivity,LiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId());
                    //设置 1: 拍卖中  2:看房中：3 :看房（不能报名）
                    if(mData.get(position).getHouseInfo().getSeeHouseStatus() == 1 && mData.get(position).getAuctionInfo().getSignStatus() == 0 &&
                            mData.get(position).getAuctionInfo().getAuctionStatus()!=2){
                        //看房中不能报名
                        intent.putExtra("live_type",3);
                    }else if(mData.get(position).getHouseInfo().getSeeHouseStatus() == 1 && mData.get(position).getAuctionInfo().getSignStatus() == 1 &&
                            mData.get(position).getAuctionInfo().getAuctionStatus()==0){
                        //看房中可以报名
                        intent.putExtra("live_type",2);
                    }else{
                        //拍卖中
                        intent.putExtra("live_type",1);
                    }
                    Log.e("TAG", "getHouseId:" + mData.get(position).getAuctionInfo().getHouseId() +
                            "getAuctionId" + mData.get(position).getHouseInfo().getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
                }else{
                    //未直播
                    Intent intent =  new Intent(mActivity,NoLiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId());
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
//                    Log.e("TAG", "getHouseId:" + mData.get(position).getHouseId() +
//                            "getAuctionId" + mData.get(position).getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        num = 1;
        if(Utils.nullToString(ACache.get(mActivity).getAsString("userId")).equals("")){
            recyclerView.showEmpty();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.netForList(Utils.nullToString(ACache.get(mActivity).getAsString("userId")));
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        if(Utils.nullToString(ACache.get(mActivity).getAsString("userId")).equals("")){
            recyclerView.showEmpty();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForMoreList(Utils.nullToString(ACache.get(mActivity).getAsString("userId")),++num);
            }
        }, 2000);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSuccessful(List<CollectionListBean.DataBean.PageDataBean> data) {
        mData.clear();
        adapter.clear();
        if(data.size() == 0){
            recyclerView.showEmpty();
            return;
        }

        mData.addAll(data);
        adapter.addAll(data);
    }

    @Override
    public void loadMoreSuccessful(List<CollectionListBean.DataBean.PageDataBean> data) {
        if(data.size()>0){
            mData.addAll(data);
            adapter.addAll(data);
        } else {
            adapter.addAll(data);
        }
    }
}
