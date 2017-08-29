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
import com.baichao.yichuipai.activity.module.AnchorPassTaskBean;
import com.baichao.yichuipai.activity.presenter.AnchorPassTaskPresenter;
import com.baichao.yichuipai.activity.presenter.AnchorPassTaskPresenterImpl;
import com.baichao.yichuipai.activity.view.AnchorPassTaskView;
import com.baichao.yichuipai.adapter.AnchorHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityAnchorPassTaskBinding;
import com.baichao.yichuipai.utils.ACache;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class AnchorPassTaskActivity extends BaseActivity implements AnchorPassTaskView,
        RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener  {

    private ActivityAnchorPassTaskBinding binding;
    private AnchorPassTaskPresenter presenter;
    private RecyclerArrayAdapter<AnchorPassTaskBean.DataBean.PageDataBean> adapter;
    private List<AnchorPassTaskBean.DataBean.PageDataBean> mData;
    private int num;
    private Handler handler = new Handler();

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anchor_pass_task);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new AnchorPassTaskPresenterImpl(mContext,this);
        mData = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.passTaskRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#eeeeee"),2, 20,0);
        itemDecoration.setDrawLastItem(false);
        binding.passTaskRecycler.addItemDecoration(itemDecoration);
        binding.passTaskRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<AnchorPassTaskBean.DataBean.PageDataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new AnchorHolder(viewGroup,mContext);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        binding.passTaskRecycler.setRefreshListener(this);
        num = 1;
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
        binding.anchorTaskPassReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(AnchorPassTaskActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSuccessful(List<AnchorPassTaskBean.DataBean.PageDataBean> data) {
        if(data.size() == 0){
            binding.passTaskRecycler.showEmpty();
            return;
        }
        mData.clear();
        adapter.clear();

        mData.addAll(data);
        adapter.addAll(data);
    }

    @Override
    public void loadMoreSuccessful(List<AnchorPassTaskBean.DataBean.PageDataBean> data) {
        if(data.size()>0){
            mData.addAll(data);
            adapter.addAll(data);
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
                presenter.netForList(ACache.get(mContext).getAsString("userId"));
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载更多
                presenter.netForList(ACache.get(mContext).getAsString("userId"),++num);
            }
        }, 2000);
    }
}
