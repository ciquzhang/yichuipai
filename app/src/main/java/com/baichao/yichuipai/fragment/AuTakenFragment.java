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
import com.baichao.yichuipai.adapter.TakenHolder;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.fragment.moudule.TakenListBean;
import com.baichao.yichuipai.fragment.presenter.AuTakenPresenter;
import com.baichao.yichuipai.fragment.presenter.AuTakenPresenterImpl;
import com.baichao.yichuipai.fragment.view.AuTakenView;
import com.baichao.yichuipai.utils.ACache;
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

public class AuTakenFragment extends BaseFragment implements AuTakenView,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private EasyRecyclerView recyclerView;
    private AuTakenPresenter presenter;
    private RecyclerArrayAdapter<TakenListBean.DataBean.PageDataBean> adapter;
    private List<TakenListBean.DataBean.PageDataBean> mData;
    private Handler handler = new Handler();
    private int num = 1;
    /**
     * 是否创建
     */
    protected boolean isCreate = false;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(mActivity,R.layout.auction_taken,null);
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.taken_recycler);
        isCreate = true;
        return view;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        mData = new ArrayList<>();
        presenter = new AuTakenPresenterImpl(mActivity,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),20, 0,0);
        itemDecoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<TakenListBean.DataBean.PageDataBean>(mActivity) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new TakenHolder(viewGroup,mActivity);
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreate) {
            //相当于Fragment的onResume
            //在这里处理加载数据等操作
            onRefresh();
        } else {
            //相当于Fragment的onPause
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                presenter.addPv(mData.get(position).getHouseInfo().getId() + "");

                // 判断该进入直播还是非直播
                if(mData.get(position).getAuctionInfo().getLiveStatus() == 1){
                    //直播
                    Intent intent =  new Intent(mActivity,LiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId() + "");
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId() + "");
                    Log.e("TAG", "--直播houseId--" + mData.get(position).getHouseInfo().getId() + "---auctionId" +
                            mData.get(position).getAuctionInfo().getId() + "userId" + ACache.get(mActivity).getAsString("userId"));
                    startActivity(intent);
                }else{
                    //非直播
                    Intent intent =  new Intent(mActivity,NoLiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseInfo().getId() + "");
                    intent.putExtra("auctionId",mData.get(position).getAuctionInfo().getId() + "");
                    Log.e("TAG", "--直播houseId--" + mData.get(position).getHouseInfo().getId() + "---auctionId" +
                            mData.get(position).getAuctionInfo().getId() + "userId" + ACache.get(mActivity).getAsString("userId"));
                    startActivity(intent);
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
    public void refreshSuccessful(List<TakenListBean.DataBean.PageDataBean> data) {
        mData.clear();
        adapter.clear();
        if(data.size() == 0){
            recyclerView.showEmpty();
        }else{
            mData.addAll(data);
            adapter.addAll(data);
        }
    }

    @Override
    public void loadMoreSuccessful(List<TakenListBean.DataBean.PageDataBean> data) {
        if(data.size()>0){
            mData.addAll(data);
            adapter.addAll(data);
        } else {
            adapter.addAll(data);
        }
    }
}






