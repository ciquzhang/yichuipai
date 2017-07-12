package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.DepositBean;
import com.baichao.yichuipai.activity.presenter.DepositPresenter;
import com.baichao.yichuipai.activity.presenter.DepositPresenterImpl;
import com.baichao.yichuipai.activity.view.DepositView;
import com.baichao.yichuipai.adapter.DepositHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityDepositBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.DateUtil;
import com.baichao.yichuipai.utils.Utils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class DepositActivity extends BaseActivity implements DepositView {

    private ActivityDepositBinding binding;
    private DepositPresenter presenter;
    private RecyclerArrayAdapter<DepositBean.DataBean> adapter;
    private List<DepositBean.DataBean> mData;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_deposit);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new DepositPresenterImpl(mContext,this);
        mData = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.depositRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#eeeeee"),1, 10,0);
        itemDecoration.setDrawLastItem(false);
        binding.depositRecycler.addItemDecoration(itemDecoration);
        binding.depositRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<DepositBean.DataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new DepositHolder(viewGroup,mContext);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.netForList(Utils.nullToString(ACache.get(mContext).getAsString("userId")));
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 返回
         */
        binding.attentionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 押金详细页
         */
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mContext,DepositDetailedActivity.class);
                if(mData.get(position).getDepositStatus() == 0){
                    intent.putExtra("deposit_type","闲置");
                }else{
                    intent.putExtra("deposit_type","冻结");
                }
                intent.putExtra("depositId",mData.get(position).getId()+"");
                intent.putExtra("price","￥ " + mData.get(position).getAmount());
                intent.putExtra("address","");
                intent.putExtra("createTime", DateUtil.getDateToString(mData.get(position).getCreateTime()));
                if(mData.get(position).getThawTime()!=null){
                    intent.putExtra("thawTime", DateUtil.getDateToString(mData.get(position).getThawTime()));
                }else {
                    intent.putExtra("thawTime", "");
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDatas(List<DepositBean.DataBean> data) {
        if (data.size() == 0) {
            binding.depositRecycler.showEmpty();
            return;
        }
        mData.addAll(data);
        adapter.addAll(data);
    }
}
