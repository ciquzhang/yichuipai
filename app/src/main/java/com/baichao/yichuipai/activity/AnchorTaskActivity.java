package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.AnchorTaskBean;
import com.baichao.yichuipai.activity.presenter.AnchorTaskPresenter;
import com.baichao.yichuipai.activity.presenter.AnchorTaskPresenterImpl;
import com.baichao.yichuipai.activity.view.AnchorTaskView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityAnchorTaskBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.DateUtil;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AnchorTaskActivity extends BaseActivity implements AnchorTaskView{

    private ActivityAnchorTaskBinding binding;
    private AnchorTaskPresenter presenter;
    private CommonAdapter<AnchorTaskBean.DataBean.TodayTaskListBean> todayAdapter;
    private CommonAdapter<AnchorTaskBean.DataBean.TomorrowTaskListBean> futureAdapter;
    private List<AnchorTaskBean.DataBean.TodayTaskListBean> todayData;
    private List<AnchorTaskBean.DataBean.TomorrowTaskListBean> futureData;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anchor_task);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new AnchorTaskPresenterImpl(mContext,this);
        todayData = new ArrayList<>();
        futureData = new ArrayList<>();
        LinearLayoutManager todayManager = new LinearLayoutManager(mContext);
        LinearLayoutManager futureManager = new LinearLayoutManager(mContext);
        DividerDecoration todayDecoration = new DividerDecoration(Color.parseColor("#eeeeee"),2, 10,0);
        DividerDecoration futureDecoration = new DividerDecoration(Color.parseColor("#eeeeee"),2, 10,0);
        todayDecoration.setDrawLastItem(false);
        futureDecoration.setDrawLastItem(false);
        binding.anchorTodayRecycler.setLayoutManager(todayManager);
        binding.anchorFutureRecycler.setLayoutManager(futureManager);
        binding.anchorTodayRecycler.addItemDecoration(todayDecoration);
        binding.anchorFutureRecycler.addItemDecoration(futureDecoration);
        binding.anchorTodayRecycler.setAdapter(todayAdapter = new CommonAdapter<AnchorTaskBean.DataBean.TodayTaskListBean>(mContext,R.layout.item_anchor_today,todayData) {
            @Override
            protected void convert(ViewHolder viewHolder, AnchorTaskBean.DataBean.TodayTaskListBean todayTaskListBean, int i) {
                viewHolder.setText(R.id.anchor_today_title,"[" + DateUtil.getDateToAnchorString(todayTaskListBean.getBeginTime()) + "]" + todayTaskListBean.getTaskName());
                viewHolder.setText(R.id.anchor_today_content,todayTaskListBean.getTaskDesc());
            }
        });

        binding.anchorFutureRecycler.setAdapter(futureAdapter = new CommonAdapter<AnchorTaskBean.DataBean.TomorrowTaskListBean>(mContext,R.layout.item_anchor_today,futureData) {

            @Override
            protected void convert(ViewHolder viewHolder, AnchorTaskBean.DataBean.TomorrowTaskListBean tomorrowTaskListBean, int i) {
                viewHolder.setText(R.id.anchor_today_title,"[" + DateUtil.getDateToAnchorString(tomorrowTaskListBean.getBeginTime()) + "]" + tomorrowTaskListBean.getTaskName());
                viewHolder.setText(R.id.anchor_today_content,tomorrowTaskListBean.getTaskDesc());
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.netForList(ACache.get(mContext).getAsString("userId"));
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 今日任务点击监听
         */
        todayAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
                Intent intent = new Intent(mContext,AnchorH5Activity.class);
                intent.putExtra("anchorH5",todayData.get(position).getId());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                return false;
            }
        });

        /**
         * 未来任务点击监听
         */
        futureAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
                Intent intent = new Intent(mContext,AnchorH5Activity.class);
                intent.putExtra("anchorH5",todayData.get(position).getId());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                return false;
            }
        });

        /**
         * 往日任务
         */
        binding.anchorTaskPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,AnchorPassTaskActivity.class));
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(AnchorTaskActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getListSuccess(AnchorTaskBean.DataBean data) {
        //今日任务
        if(data.getTodayTaskList()!=null || data.getTodayTaskList().size()>0){
            todayData.addAll(data.getTodayTaskList());
            todayAdapter.notifyDataSetChanged();
        }else{
            binding.anchorTodayRecycler.setVisibility(View.GONE);
        }

        //未来任务
        if(data.getTodayTaskList()!=null){
            futureData.addAll(data.getTomorrowTaskList());
            futureAdapter.notifyDataSetChanged();
        }else{
            binding.anchorFutureRecycler.setVisibility(View.GONE);
        }
    }

    @Override
    public void getListNull(){
        binding.anchorTodayRecycler.setVisibility(View.GONE);
        binding.anchorFutureRecycler.setVisibility(View.GONE);
    }
}
