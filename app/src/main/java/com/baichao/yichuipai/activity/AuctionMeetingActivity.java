package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.MeetingListBean;
import com.baichao.yichuipai.activity.presenter.AuctionMeetingPresenter;
import com.baichao.yichuipai.activity.presenter.AuctionMeetingPresenterImpl;
import com.baichao.yichuipai.activity.view.AuctionMeetingView;
import com.baichao.yichuipai.adapter.MeetingHolder;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityAuctionMeetingBinding;
import com.baichao.yichuipai.utils.Constant;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

public class AuctionMeetingActivity extends BaseActivity implements AuctionMeetingView{

    private ActivityAuctionMeetingBinding binding;
    private AuctionMeetingPresenter presenter;
    private RecyclerArrayAdapter<MeetingListBean.DataBean> adapter;
    private Handler handler = new Handler();
    private int num = 1;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auction_meeting);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new AuctionMeetingPresenterImpl(mContext,this);
        binding.auctionTitle.setText(getIntent().getStringExtra("auctionMeetingName"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        binding.meetingRecycler.setLayoutManager(layoutManager);
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#f4f4f4"),10, 0,0);
        itemDecoration.setDrawLastItem(false);
        binding.meetingRecycler.addItemDecoration(itemDecoration);
        binding.meetingRecycler.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<MeetingListBean.DataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
                return new MeetingHolder(viewGroup,mContext);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.netForList(getIntent().getStringExtra("auctionMeetingId"));
    }

    @Override
    protected void initListener() {
        super.initListener();

        /**
         * 返回
         */
        binding.meetingReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 下一步
         */
        binding.meetingNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,SignUpActivity.class);
                intent.putExtra("houseId",getIntent().getStringExtra("houseId"));
                intent.putExtra("auctionMeetingId",getIntent().getStringExtra("auctionMeetingId"));
                intent.putExtra("regionId",getIntent().getStringExtra("regionId"));
                intent.putExtra("amount",getIntent().getStringExtra("amount"));
                startActivityForResult(intent, Constant.REQUEST_SIGN);
            }
        });

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSuccess(List<MeetingListBean.DataBean> data) {
        if(data.size() == 0){
            binding.meetingRecycler.showEmpty();
            return;
        }
        adapter.addAll(data);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constant.REQUEST_SIGN){
            setResult(Constant.RESULT_LOGIN);
            finish();
        }
    }
}
