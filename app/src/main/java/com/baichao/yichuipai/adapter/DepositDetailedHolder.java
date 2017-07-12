package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.DepositDetailedBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DepositDetailedHolder extends BaseViewHolder<DepositDetailedBean.DataBean.PageDataBean.DepositAndHouseListBean> {

    private Context context;
    private TextView type;
    private ImageView imageView;
    private TextView title;
    private TextView price;
    private TextView count;
    private TextView price_type;

    public DepositDetailedHolder(ViewGroup parent,Context context) {
        super(parent, R.layout.item_home);
        this.context = context;
        type = $(R.id.home_type);
        imageView = $(R.id.home_img);
        title = $(R.id.home_title);
        price = $(R.id.home_price);
        count = $(R.id.home_person_count);
        price_type = $(R.id.home_price_type);
    }

    @Override
    public void setData(DepositDetailedBean.DataBean.PageDataBean.DepositAndHouseListBean data) {
        super.setData(data);
        if(data.getAuctionInfo().getAuctionStatus() == 2 && data.getAuctionInfo().getLiveStatus() == 1 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //拍卖中
            type.setText("拍卖中");
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //无状态
            type.setVisibility(View.GONE);
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 1 && data.getHouseInfo().getSeeHouseStatus()==0){
            //报名中
            type.setText("报名中");
            type.setBackgroundResource(R.drawable.home_type_shape_2);
        }else if(data.getAuctionInfo().getSignStatus() == 1 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            type.setBackgroundResource(R.drawable.home_type_shape_1);
        }else if(data.getAuctionInfo().getSignStatus() == 0 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            type.setBackgroundResource(R.drawable.home_type_shape_1);
        }else if(data.getAuctionInfo().getAuctionStatus() == 3){
            type.setText("已结束");
            type.setBackgroundResource(R.drawable.home_type_shape_3);
        }else if(data.getAuctionInfo().getAuctionStatus() == 4){
            type.setText("流拍");
            type.setBackgroundResource(R.drawable.home_type_shape_3);
        }
        if(data.getAuctionInfo().getAuctionStatus()==2){
            price_type.setText("当前价");
            price.setText(Utils.nullToString(data.getAuctionInfo().getCurrentPrice()));
        }else{
            price_type.setText("评估价");
            price.setText(Utils.nullToString(data.getHouseInfo().getEvalautePrice()));
        }
        //标题
        title.setText("[" + data.getName() + "]" + Utils.nullToString(data.getHouseInfo().getTitle()));
        //围观人数
        count.setText(Utils.nullToString(data.getHouseInfo().getPv()));
        imageView.setBackgroundResource(R.drawable.home_bg_shape);
        Glide.with(context).load(Constant.APP_IMAGE + data.getHouseInfo().getImgUrl()).error(R.drawable.zhibo_house).into(imageView);
    }
}
