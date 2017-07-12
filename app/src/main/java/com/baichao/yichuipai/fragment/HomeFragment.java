package com.baichao.yichuipai.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.LiveActivity;
import com.baichao.yichuipai.activity.NoLiveActivity;
import com.baichao.yichuipai.activity.PassAuctionActivity;
import com.baichao.yichuipai.adapter.HomeHolder;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.databinding.FragHomeBinding;
import com.baichao.yichuipai.fragment.moudule.HomeBean;
import com.baichao.yichuipai.fragment.presenter.HomePresenterImpl;
import com.baichao.yichuipai.fragment.view.HomeView;
import com.baichao.yichuipai.utils.Constant;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.my.view.CarouselFigureView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pll on 2017/5/3.
 */

public class HomeFragment extends BaseFragment implements HomeView,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private FragHomeBinding binding;
    private HomePresenterImpl presenter;
    private ArrayList<HomeBean.DataBean.PageDataBean> mData;
    private RecyclerArrayAdapter<HomeBean.DataBean.PageDataBean> adapter;
    private Handler handler = new Handler();
    private int num = 1;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_home, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        mData = new ArrayList<>();
        presenter = new HomePresenterImpl(this,mActivity);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        binding.homeRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),10, 0,0);
        itemDecoration.setDrawLastItem(false);
        binding.homeRecycler.addItemDecoration(itemDecoration);
        binding.homeRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<HomeBean.DataBean.PageDataBean>(mActivity) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new HomeHolder(viewGroup,mActivity);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        binding.homeRecycler.setRefreshListener(this);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup viewGroup) {
                LayoutInflater inflater = mActivity.getLayoutInflater();
                View view = inflater.inflate(R.layout.frag_home_head, null);
                CarouselFigureView carouselFigureView = (CarouselFigureView) view.findViewById(R.id.home_fv);
                RelativeLayout pass = (RelativeLayout) view.findViewById(R.id.home_to_pass);
                presenter.headLoading(carouselFigureView);
                /**
                 * 往期视频
                 */
                pass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(),PassAuctionActivity.class));
                    }
                });
                return view;
            }

            @Override
            public void onBindView(View view) {

            }
        });
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
                if(mData.get(position).getLiveStatus() == 1){
                    //直播中
                    Intent intent =  new Intent(mActivity,LiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionId());
                    //设置 1: 拍卖中  2:看房中：3 :看房（不能报名）
                    if(mData.get(position).getSeeHouseStatus() == 1 && mData.get(position).getSignStatus() == 0 &&
                            mData.get(position).getAuctionStatus()!=2){
                        //看房中不能报名
                        intent.putExtra("live_type",3);
                    }else if(mData.get(position).getSeeHouseStatus() == 1 && mData.get(position).getSignStatus() == 1 &&
                            mData.get(position).getAuctionStatus()==0){
                        //看房中可以报名
                        intent.putExtra("live_type",2);
                    }else{
                        //拍卖中
                        intent.putExtra("live_type",1);
                    }
                    Log.e("TAG", "getHouseId:" + mData.get(position).getHouseId() +
                            "getAuctionId" + mData.get(position).getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
                }else{
                    //未直播
                    Intent intent =  new Intent(mActivity,NoLiveActivity.class);
                    intent.putExtra("houseId",mData.get(position).getHouseId());
                    intent.putExtra("auctionId",mData.get(position).getAuctionId());
                    if(mData.get(position).getAuctionStatus() == 2 && mData.get(position).getSignStatus() == 0){
                        //拍卖中
                        intent.putExtra("live_type",1);
                    }
                    if(mData.get(position).getAuctionStatus() != 2 && mData.get(position).getSignStatus() == 1){
                        //报名中 -->未开始直播,可以报名
                        intent.putExtra("live_type",4);
                    }else if(mData.get(position).getAuctionStatus() != 2 && mData.get(position).getSignStatus() == 0){
                        //停止报名 --> 未开始直播，不能报名
                        intent.putExtra("live_type",5);
                    }
                    Log.e("TAG", "getHouseId:" + mData.get(position).getHouseId() +
                            "getAuctionId" + mData.get(position).getAuctionId());
                    startActivityForResult(intent, Constant.REQUEST_LIVE_TO_MY);
                }
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadSuccessful(List<HomeBean.DataBean.PageDataBean> list) {
        if(list.size()>0){
            mData.addAll(list);
            adapter.addAll(list);
        } else {
            adapter.addAll(list);
        }
    }

    @Override
    public void refreshSuccessful(List<HomeBean.DataBean.PageDataBean> list) {
        if(list.size() == 0){
            binding.homeRecycler.showEmpty();
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
                presenter.netForHomeList();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForHomeListMore(++num);
            }
        }, 2000);
    }
}
