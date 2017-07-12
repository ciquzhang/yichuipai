package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.DepositDetailedBean;
import com.baichao.yichuipai.activity.presenter.DepositDetailedPresenter;
import com.baichao.yichuipai.activity.presenter.DepositDetailedPresenterImpl;
import com.baichao.yichuipai.activity.view.DepositDetailedView;
import com.baichao.yichuipai.adapter.DepositDetailedHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityDepositDetailedBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Utils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class DepositDetailedActivity extends BaseActivity implements DepositDetailedView ,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private ActivityDepositDetailedBinding binding;
    private Handler handler = new Handler();
    private int num;
    private DepositDetailedPresenter presenter;
    private RecyclerArrayAdapter<DepositDetailedBean.DataBean.PageDataBean.DepositAndHouseListBean> adapter;
    private List<DepositDetailedBean.DataBean.PageDataBean> mData;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit_detailed);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        mData = new ArrayList<>();
        presenter = new DepositDetailedPresenterImpl(mContext,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.depositDetailedRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),20, 0,0);
        itemDecoration.setDrawLastItem(false);
        binding.depositDetailedRecycler.addItemDecoration(itemDecoration);
        binding.depositDetailedRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<DepositDetailedBean.DataBean.PageDataBean.DepositAndHouseListBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new DepositDetailedHolder(viewGroup,mContext);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        binding.depositDetailedRecycler.setRefreshListener(this);
        onRefresh();
    }

    @Override
    protected void initData() {
        super.initData();
        viewSetting();
    }

    private void viewSetting() {
        binding.depositDetailedPrice.setText(getIntent().getStringExtra("price"));
        binding.depositDetailedType.setText(getIntent().getStringExtra("deposit_type"));
        binding.depositDetailedCreatTime.setText(getIntent().getStringExtra("createTime"));
        binding.depositDetailedThawTime.setText(getIntent().getStringExtra("thawTime"));
        binding.depositDetailedAddress.setText(getIntent().getStringExtra("address"));
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSuccess(List<DepositDetailedBean.DataBean.PageDataBean> data) {
        mData.clear();
        adapter.clear();

        if(data.size() == 0){
            binding.depositDetailedRecycler.showEmpty();
            return;
        }

        mData.addAll(data);
        for(int i = 0;i<data.size();i++){
            for(int j = 0;j<data.get(i).getDepositAndHouseList().size();j++){
                data.get(i).getDepositAndHouseList().get(j).setName(data.get(i).getAuctionMeeting().getName());
            }
            adapter.addAll(data.get(i).getDepositAndHouseList());
        }
    }

    @Override
    public void loadMoreSuccessful(List<DepositDetailedBean.DataBean.PageDataBean> data) {
        if(data.size()>0){
            mData.addAll(data);
            for(int i = 0;i<data.size();i++){
                for(int j = 0;j<data.get(i).getDepositAndHouseList().size();j++){
                    data.get(i).getDepositAndHouseList().get(j).setName(data.get(i).getAuctionMeeting().getName());
                }
                adapter.addAll(data.get(i).getDepositAndHouseList());
            }
        } else {
            adapter.addAll(new ArrayList<DepositDetailedBean.DataBean.PageDataBean.DepositAndHouseListBean>());
        }
    }

    @Override
    public void onRefresh() {
        num = 1;
        if(Utils.nullToString(ACache.get(mContext).getAsString("userId")).equals("")){
            binding.depositDetailedRecycler.showEmpty();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.netForList(getIntent().getStringExtra("depositId"));
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        if(Utils.nullToString(ACache.get(mContext).getAsString("userId")).equals("")){
            binding.depositDetailedRecycler.showEmpty();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForMoreList(getIntent().getStringExtra("depositId"),++num);
            }
        }, 2000);
    }
}
