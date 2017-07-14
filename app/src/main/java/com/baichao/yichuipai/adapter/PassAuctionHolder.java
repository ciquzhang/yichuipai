package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.PassAuctionListBean;
import com.baichao.yichuipai.utils.DateUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/11.
 */

public class PassAuctionHolder extends BaseViewHolder<PassAuctionListBean.DataBean.PageDataBean> {

    private Context context;
    private TextView pass_auction_id;
    private TextView applied_title;
    private TextView pass_auction_price;
    private TextView pass_auction_time;
    private TextView pass_sign_up_count;
    private TextView pass_price_count;
    private TextView pass_look_count;
    private TextView pass_auction_type;


    public PassAuctionHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.item_pass_auctiuon);
        this.context = context;
        pass_auction_id = $(R.id.pass_auction_id);
        applied_title = $(R.id.applied_title);
        pass_auction_price = $(R.id.pass_auction_price);
        pass_auction_time = $(R.id.pass_auction_time);
        pass_sign_up_count = $(R.id.pass_sign_up_count);
        pass_price_count = $(R.id.pass_price_count);
        pass_look_count = $(R.id.pass_look_count);
        pass_auction_type = $(R.id.pass_auction_type);
    }

    @Override
    public void setData(PassAuctionListBean.DataBean.PageDataBean data){
        super.setData(data);
        if(data.getAuctionInfo().getAuctionStatus() == 4){
            //流拍
            pass_auction_type.setText("流拍");
            pass_auction_type.setBackgroundResource(R.drawable.pass_btn_shape_4);
            //拍卖时间
            pass_auction_id.setText("拍卖时间  " + DateUtil.getDateToString(data.getAuctionMeeting().getStartTime()));
            //成交价
            pass_auction_price.setText("--");
            //成交时间
            pass_auction_time.setText("成交时间  --");
        }else if(data.getAuctionResult().getTranStatus() == 1){
            //交易中
            pass_auction_type.setText("交易中");
            pass_auction_type.setBackgroundResource(R.drawable.pass_btn_shape_1);
            //竞买号
            pass_auction_id.setText("成交竞买号  " + data.getAuctionRecord().getBidNo());
            //成交价
            pass_auction_price.setText("￥ " + data.getAuctionResult().getPrice());
            //成交时间
            if(data.getAuctionResult().getCreateTime() == 0){
                pass_auction_time.setText("成交时间  --");
            }else{
                pass_auction_time.setText("成交时间 " + DateUtil.getDateToString(data.getAuctionResult().getCreateTime()));
            }
        }else if(data.getAuctionResult().getTranStatus() == 2){
            //交易完成
            pass_auction_type.setText("成功交易");
            pass_auction_type.setBackgroundResource(R.drawable.pass_btn_shape_2);
            //竞买号
            pass_auction_id.setText("成交竞买号  " + data.getAuctionRecord().getBidNo());
            //成交价
            pass_auction_price.setText("￥ " + data.getAuctionResult().getPrice());
            //成交时间
            if(data.getAuctionResult().getCreateTime() == 0){
                pass_auction_time.setText("成交时间  --");
            }else{
                pass_auction_time.setText("成交时间 " + DateUtil.getDateToString(data.getAuctionResult().getCreateTime()));
            }
        }else if(data.getAuctionResult().getTranStatus() == 3){
            //交易终止
            pass_auction_type.setText("交易失败");
            pass_auction_type.setBackgroundResource(R.drawable.pass_btn_shape_3);
            //竞买号
            pass_auction_id.setText("成交竞买号  " + data.getAuctionRecord().getBidNo());
            //成交价
            pass_auction_price.setText("￥ " + data.getAuctionResult().getPrice());
            //成交时间
            if(data.getAuctionResult().getCreateTime() == 0){
                pass_auction_time.setText("成交时间  --");
            }else{
                pass_auction_time.setText("成交时间 " + DateUtil.getDateToString(data.getAuctionResult().getCreateTime()));
            }
        }
        //标题
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00b589"));
        SpannableStringBuilder builder = new SpannableStringBuilder("[" + data.getAuctionMeeting().getName() + "]" + data.getHouseInfo().getTitle());
        builder.setSpan(span, 0, data.getAuctionMeeting().getName().length()+2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        applied_title.setText(builder);

        //报名
        pass_sign_up_count.setText(data.getAuctionMeeting().getSignCount()+"人报名");
        //出价人数
        pass_price_count.setText(data.getCountRecord()+"人出价");
        //围观
        pass_look_count.setText(data.getHouseInfo().getPv()+"次围观");
    }
}
