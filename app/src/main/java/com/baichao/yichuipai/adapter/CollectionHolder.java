package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.fragment.moudule.CollectionListBean;
import com.baichao.yichuipai.utils.Constant;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/3.
 */

public class CollectionHolder extends BaseViewHolder<CollectionListBean.DataBean.PageDataBean> {

    private Context context;
    private TextView title;
    private TextView type;
    private ImageView icon;
    private TextView price;
    private TextView price_type;
    private TextView count_sign;
    private TextView count_price;
    private TextView count_look;
    private TextView collect_time;

    public CollectionHolder(ViewGroup parent,Context context) {
        super(parent, R.layout.item_collection);
        this.context = context;
        title = $(R.id.collect_title);
        type = $(R.id.collect_type);
        icon = $(R.id.collect_image);
        price = $(R.id.collect_price);
        price_type = $(R.id.collect_price_type);
        count_sign = $(R.id.collect_sign_up_count);
        count_price = $(R.id.collect_price_count);
        count_look = $(R.id.collect_look_count);
        collect_time = $(R.id.collect_time);
    }

    @Override
    public void setData(CollectionListBean.DataBean.PageDataBean data) {
        super.setData(data);
        if(data.getAuctionInfo().getAuctionStatus() == 3 || data.getAuctionInfo().getAuctionStatus() == 4){
            type.setText("已结束");
            collect_time.setText("");
            price_type.setText("成交价");
            price.setTextColor(Color.parseColor("#333333"));
            price.setText(data.getAuctionInfo().getCurrentPrice()+"");
        }else if(data.getAuctionInfo().getAuctionStatus() == 2 &&
                data.getAuctionMeeting().getSignStatus() == 2 &&
                data.getHouseInfo().getSeeHouseStatus()==0){
            //拍卖中
            type.setText("拍卖中");
            price_type.setText("当前价");
            type.setBackgroundResource(R.drawable.collection_shape_1);
            price.setTextColor(Color.parseColor("#F46a2d"));
            price.setText(data.getAuctionInfo().getCurrentPrice()+"");
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionMeeting().getSignStatus() == 0 &&
                data.getHouseInfo().getSeeHouseStatus()==0){
            //无状态
            type.setText("已结束");
            type.setVisibility(View.GONE);
            price_type.setText("起拍价");
            price.setText("￥" + data.getAuctionInfo().getStartPrice());
            collect_time.setText("");
            price.setTextColor(Color.parseColor("#F46a2d"));
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionMeeting().getSignStatus() == 2 &&
                data.getHouseInfo().getSeeHouseStatus()==0){
            type.setText("报名结束");
            price_type.setText("起拍价");
            price.setText("￥" + data.getAuctionInfo().getStartPrice());
            price.setTextColor(Color.parseColor("#F46a2d"));
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionMeeting().getSignStatus() == 1 &&
                data.getHouseInfo().getSeeHouseStatus()==0){
            //报名中
            type.setText("报名中");
            price_type.setText("起拍价");
            price.setTextColor(Color.parseColor("#F46a2d"));
            price.setText("￥" + data.getAuctionInfo().getStartPrice());
            type.setBackgroundResource(R.drawable.collection_shape_2);
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            price_type.setText("起拍价");
            price.setText("￥" + data.getAuctionInfo().getStartPrice());
            price.setTextColor(Color.parseColor("#F46a2d"));
            type.setBackgroundResource(R.drawable.collection_shape_3);
        }
        //标题
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00b589"));
        SpannableStringBuilder builder = new SpannableStringBuilder("[" + data.getAuctionMeeting().getName() + "]" + data.getHouseInfo().getTitle());
        builder.setSpan(span, 0, data.getAuctionMeeting().getName().length()+2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        title.setText(builder);
        //报名
        count_sign.setText(data.getAuctionMeeting().getSignCount()+"人报名");
        //提醒人数
        count_price.setText(data.getAuctionInfo().getCollectionCount()+"人设置提醒");
        //围观
        count_look.setText(data.getHouseInfo().getPv()+"次围观");
        //icon
        Glide.with(context).load(Constant.APP_IMAGE + data.getHouseInfo().getImgUrl()).error(R.drawable.zhibo_house).into(icon);
    }
}
