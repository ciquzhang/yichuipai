package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.fragment.moudule.CollectionListBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
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
    }

    @Override
    public void setData(CollectionListBean.DataBean.PageDataBean data) {
        super.setData(data);
        if(data.getAuctionInfo().getAuctionStatus() == 2 && data.getAuctionInfo().getLiveStatus() == 1 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //拍卖中
            type.setText("拍卖中");
            type.setBackgroundResource(R.drawable.collection_shape_1);
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //无状态
            type.setText("已结束");
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 1 && data.getHouseInfo().getSeeHouseStatus()==0){
            //报名中
            type.setText("报名中");
            type.setBackgroundResource(R.drawable.collection_shape_2);
        }else if(data.getAuctionInfo().getSignStatus() == 1 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            type.setBackgroundResource(R.drawable.collection_shape_3);
        }else if(data.getAuctionInfo().getSignStatus() == 0 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            type.setBackgroundResource(R.drawable.collection_shape_3);
        }
        if(data.getAuctionInfo().getAuctionStatus()==2){
            price_type.setText("当前价");
            price.setText(Utils.nullToString(data.getAuctionInfo().getCurrentPrice()));
        }else{
            price_type.setText("评估价");
            price.setText(Utils.nullToString(data.getHouseInfo().getEvalautePrice()));
        }
        //标题
        title.setText(data.getHouseInfo().getTitle());
        //报名
        count_sign.setText(data.getAuctionInfo().getBidCount()+"人报名");
        //提醒人数
        count_price.setText(data.getAuctionInfo().getCollectionCount()+"人设置提醒");
        //围观
        count_look.setText(data.getHouseInfo().getPv()+"次围观");
        //icon
        Glide.with(context).load(Constant.APP_IMAGE + data.getHouseInfo().getImgUrl()).error(R.drawable.zhibo_house).into(icon);
    }
}
