package com.baichao.yichuipai.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.AuctionMeetingActivity;
import com.baichao.yichuipai.activity.BuyListActivity;
import com.baichao.yichuipai.activity.LoginActivity;
import com.baichao.yichuipai.activity.OfferActivity;
import com.baichao.yichuipai.activity.module.HouseInfoDetailBean;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.databinding.FragLive1Binding;
import com.baichao.yichuipai.fragment.presenter.LiveFragPresenter;
import com.baichao.yichuipai.fragment.presenter.LiveFragPresenterImpl;
import com.baichao.yichuipai.fragment.view.LiveFragView;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.DateUtil;
import com.jakewharton.rxbinding.view.RxView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

/**
 * Created by Administrator on 2017/6/26.
 */

@SuppressLint("ValidFragment")
public class Live1Fragment extends BaseFragment implements LiveFragView{

    private FragLive1Binding binding;
    private HouseInfoDetailBean.DataBean data;
    private CommonAdapter<HouseInfoDetailBean.DataBean.AuctionRecordsBean> adapter;
    List<HouseInfoDetailBean.DataBean.AuctionRecordsBean> list;
    private int live_buy;
    //房产是否被收藏
    private boolean isCollection = false;
    //出价或者是报名
    private String btn_type = "0";
    private LiveFragPresenter presenter;
    private String houseId;
    private String auctionId;

    @SuppressLint("ValidFragment")
    public Live1Fragment(int live_buy ,HouseInfoDetailBean.DataBean dataBean,String houseId,String auctionId) {
        this.live_buy = live_buy;
        this.data = dataBean;
        this.houseId = houseId;
        this.auctionId = auctionId;
    }

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_live1, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new LiveFragPresenterImpl(mActivity,this);
    }

    @Override
    protected void initData() {
        super.initData();
        viewSetting();
        topRecycleSetting();
    }

    private void topRecycleSetting() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        list = new ArrayList<>();
        if(data.getAuctionRecords() != null){
            list.addAll(data.getAuctionRecords());
        }
        adapter = new CommonAdapter<HouseInfoDetailBean.DataBean.AuctionRecordsBean>(mActivity,R.layout.item_live_price,list) {
            @Override
            protected void convert(ViewHolder holder, HouseInfoDetailBean.DataBean.AuctionRecordsBean auctionRecordsBean, int position) {
                TextView bin = holder.getView(R.id.item_live_bin);
                TextView price = holder.getView(R.id.item_live_price);
                if(position == 0){
                    holder.getView(R.id.item_live).setBackgroundResource(R.drawable.live_price_first_shape);
                    bin.setTextColor(Color.parseColor("#ffffff"));
                    price.setTextColor(Color.parseColor("#d9fff6"));
                }else{
                    holder.getView(R.id.item_live).setBackgroundResource(R.drawable.live_price_shape);
                    bin.setTextColor(Color.parseColor("#666666"));
                    price.setTextColor(Color.parseColor("#999999"));
                }
                holder.setText(R.id.item_live_bin,auctionRecordsBean.getBidNo()+"");
                holder.setText(R.id.item_live_price,"￥" + auctionRecordsBean.getPrice()+"");
            }
        };
        binding.liveBuyListRecycle.setLayoutManager(linearLayoutManager);
        binding.liveBuyListRecycle.setAdapter(adapter);
    }

    private void viewSetting() {
        //设置标题
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00b589"));
        SpannableStringBuilder builder = new SpannableStringBuilder("[" + data.getAuctionMeeting().getName() + "]" + data.getHouseInfo().getTitle());
        builder.setSpan(span, 0, data.getAuctionMeeting().getName().length()+2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        binding.liveTitle.setText(builder);

        binding.liveSignUpCount.setText(data.getAuctionMeeting().getSignCount()+"人报名");//报名人数
        binding.liveClock.setText(data.getAuctionInfo().getCollectionCount()+"人设置提醒");//设置提醒人数
        binding.liveLookCount.setText(data.getHouseInfo().getPv()+"次围观");//围观人数
        binding.liveIncreasePrice.setText(data.getAuctionInfo().getIncreasePrice() + "");//加价幅度
        binding.liveEvalaute.setText(data.getHouseInfo().getEvalautePrice()+"");//评估价
        binding.liveStartPrice.setText(data.getAuctionInfo().getStartPrice()+"");//起拍价
        binding.liveShopType.setText(data.getAuctionInfo().getType());//类型
        binding.liveSellPeriod.setText(data.getAuctionInfo().getSellPeriod());//变卖周期
        if(data.getAuctionMeeting().getSignEndTime() == 0){
            binding.liveSignUpEnd.setText("-");//报名截止
        }else{
            binding.liveSignUpEnd.setText(DateUtil.getDateToShortString(data.getAuctionMeeting().getSignEndTime()));//报名截止
        }
        if(data.getHouseInfo().getSeeStartTime() == 0){
            binding.liveSeeHouse.setText("-");//看房时间
        }else{
            binding.liveSeeHouse.setText(DateUtil.getDateToString(data.getHouseInfo().getSeeStartTime()));//看房时间
        }
        if(data.getAuctionInfo().getSignStartTime() == 0){
            binding.liveAuctionStartTime.setText("-");//拍卖时间
        }else{
            binding.liveAuctionStartTime.setText(DateUtil.getDateToString(data.getAuctionInfo().getAuctionStartTime()));//拍卖时间
        }
        binding.liveRule.setText(data.getAuctionInfo().getBidRule()+"");//竞价规则
        binding.liveConsultWay.setText(data.getAuctionInfo().getConsultWay());//咨询方式
        binding.liveHouseAddress.setText(data.getHouseInfo().getLocation());//房产地址
        switch (live_buy) {
            case 0 :
                Log.e("TAG", "--error_live1--");
                break;
            case 1:
                //拍卖
                binding.liveCommit.setText("出价");
                binding.livePrice.setText(data.getAuctionInfo().getCurrentPrice() + "");//当前价
                btn_type = "1";
                break;
            case 2:
                //看房可以报名
                binding.liveBuy.setVisibility(View.GONE);
                binding.livePrice.setTextColor(Color.parseColor("#00B589"));
                binding.liveCurrent.setText("起拍价");
                binding.liveCommit.setText("报名");
                btn_type = "2";
                binding.livePrice.setText(data.getAuctionInfo().getStartPrice() +"");
                break;
            case 3:
                //看房不能报名
                binding.liveBuy.setVisibility(View.GONE);
                binding.livePrice.setTextColor(Color.parseColor("#00B589"));
                   binding.liveCurrent.setText("起拍价");
                binding.liveBtnCommit.setVisibility(View.GONE);
                binding.livePrice.setText(data.getAuctionInfo().getStartPrice() +"");
                break;
            case 4:
                //未开播，可以报名
                binding.livePrice.setText(data.getAuctionInfo().getStartPrice()+"");
                binding.liveBuy.setVisibility(View.GONE);
                binding.livePrice.setTextColor(Color.parseColor("#00B589"));
                binding.liveCurrent.setText("起拍价");
                binding.liveCommit.setText("报名");
                btn_type = "2";
                break;
            case 5:
                //未开播，停止报名
                binding.liveBuy.setVisibility(View.GONE);
                binding.livePrice.setTextColor(Color.parseColor("#00B589"));
                binding.liveCurrent.setText("起拍价");
                binding.livePrice.setText(data.getAuctionInfo().getStartPrice()+"");
                binding.liveBtnCommit.setVisibility(View.GONE);
                break;
        }

        /**
         * 判断是否被收藏
         */
        if(data.getHouseCollection()!=null){
            binding.liveCollectionImg.setImageResource(R.mipmap.icon_remind_o);
            binding.liveIsCollection.setText("已收藏");
            isCollection = true;
        }else{
            isCollection = false;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 收藏或者取消收藏
         */
        RxView.clicks(  binding.liveCollectionCommit )
                .throttleFirst( 1 , TimeUnit.SECONDS )   //两秒钟之内只取一个点击事件，防抖操作
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        if(ACache.get(mActivity).getAsString("token")==null || ACache.get(mActivity).getAsString("token").equals("")){
                            startActivityForResult(new Intent(mActivity, LoginActivity.class),Constant.REQUEST_LIVE);
                            showToast("请先登录");
                            return;
                        }
                        binding.liveCollectionCommit.setClickable(false);
                        if(isCollection){
                            //取消收藏
                            String id = "";
                            if(data.getHouseCollection() == null){
                                id = ACache.get(mActivity).getAsString("collectionId");
                            }else{
                                id = data.getHouseCollection().getId()+"";
                            }
                            presenter.centerCollect(id,auctionId);
                        }else{
                            //收藏
                            presenter.collectHouse(ACache.get(mActivity).getAsString("userId"),houseId,auctionId);
                        }
                    }
                }) ;

        /**
         * 出价或者报名
         */
        binding.liveCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ACache.get(mActivity).getAsString("token")==null || ACache.get(mActivity).getAsString("token").equals("")){
                    startActivityForResult(new Intent(mActivity, LoginActivity.class),Constant.REQUEST_LIVE);
                    showToast("请先登录");
                    return;
                }
                if(data.getUserInfo().getPersonAuthStatus() == 0 && data.getUserInfo().getCompanyAuthStatus() == 0){
                    //进入认证
                    getActivity().setResult(Constant.RESULT_LIVE_TO_MY);
                    showToast("请先进行认证");
                    getActivity().finish();
                    return;
                }
                if(btn_type.equals("1")){
                    //出价
                    if(data.getAuctionSignRecord()==null){
                        showToast("此拍卖您还没有报名");
                        return;
                    }
                    Log.e("TAG", "--出价--");
                    Intent intent = new Intent(mActivity,OfferActivity.class);
                    intent.putExtra("title",data.getHouseInfo().getTitle());
                    intent.putExtra("currentPrice",data.getAuctionInfo().getCurrentPrice() + "");
                    intent.putExtra("increasePrice",data.getAuctionInfo().getIncreasePrice() + "");
                    intent.putExtra("evalautePrice",data.getHouseInfo().getEvalautePrice()+"");
                    intent.putExtra("bidNo",data.getAuctionSignRecord().getBidNo());
                    intent.putExtra("auctionId",auctionId);
                    startActivityForResult(intent,Constant.REQUEST_SIGN);
                }else if(btn_type.equals("2")){
                    //报名
                    if(data.getAuctionSignRecord()!=null){
                        showToast("不能重复报名哦");
                        return;
                    }
//                    Intent intent = new Intent(mActivity,SignUpActivity.class);
                    Intent intent = new Intent(mActivity,AuctionMeetingActivity.class);
                    intent.putExtra("houseId",houseId);
                    intent.putExtra("auctionMeetingId",data.getAuctionInfo().getAuctionMeetingId()+"");
                    intent.putExtra("auctionMeetingName",data.getAuctionMeeting().getName());
                    intent.putExtra("regionId",data.getAuctionMeeting().getRegionId()+"");
                    intent.putExtra("amount",data.getAuctionMeeting().getDepositPrice()+"");
                    startActivityForResult(intent,Constant.REQUEST_SIGN);
                }
            }
        });

        /**
         * 竞买记录
         */
        binding.liveBuyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity,BuyListActivity.class);
                intent.putExtra("auctionId",auctionId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void collectSuccess() {

        binding.liveCollectionCommit.setClickable(true);
        binding.liveCollectionImg.setImageResource(R.mipmap.icon_remind_o);
        binding.liveIsCollection.setText("已收藏");
        isCollection = true;
    }

    @Override
    public void centerCollect() {
        binding.liveCollectionCommit.setClickable(true);
        isCollection = false;
        binding.liveCollectionImg.setImageResource(R.mipmap.icon_remind);
        binding.liveIsCollection.setText("点击收藏");
    }

    @Override
    public void getNewDataSuccess(HouseInfoDetailBean.DataBean dataBean) {
        data = null;
        data = dataBean;
        viewSetting();
        list.clear();
        list.addAll(data.getAuctionRecords());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Constant.RESULT_LOGIN){
            presenter.netForNewData(houseId,auctionId);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
