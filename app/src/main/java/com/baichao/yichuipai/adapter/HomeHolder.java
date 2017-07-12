package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.fragment.moudule.HomeBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/6/21.
 */

public class HomeHolder extends BaseViewHolder<HomeBean.DataBean.PageDataBean>{

    private TextView type;
    private ImageView imageView;
    private TextView title;
    private TextView price;
    private TextView count;
    private TextView price_type;
    private Context context;

    public HomeHolder(ViewGroup parent, Context context) {
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
    public void setData(HomeBean.DataBean.PageDataBean data) {
        super.setData(data);
        if(data.getAuctionStatus() == 2 && data.getHouseStatus() == 1 &&
                data.getSignStatus() != 1){
            //拍卖中
            type.setText("拍卖中");
        }else if(data.getAuctionStatus() == 0 && data.getHouseStatus() == 1 &&
                data.getSignStatus() != 1){
            //无状态
            type.setVisibility(View.GONE);
        }else if(data.getAuctionStatus() == 0 && data.getHouseStatus() == 1 &&
                data.getSignStatus() == 1){
            //报名中
            type.setText("报名中");
            type.setBackgroundResource(R.drawable.home_type_shape_2);
        } else if(data.getSignStatus() != 0 && data.getHouseStatus() == 1 &&
                data.getSeeHouseStatus() == 1){
            //看房中
            type.setText("看房中");
            type.setBackgroundResource(R.drawable.home_type_shape_1);
        }

        if(data.getAuctionStatus()==2){
            price_type.setText("当前价");
            price.setText(Utils.nullToString(data.getCurrentPrice()));
        }else{
            price_type.setText("评估价");
            price.setText(Utils.nullToString(data.getEvalautePrice()));
        }
        title.setText(Utils.nullToString(data.getTitle()));
        count.setText(Utils.nullToString(data.getPv()));
        imageView.setBackgroundResource(R.drawable.home_bg_shape);
        Glide.with(context).load(Constant.APP_IMAGE + data.getImgUrl()).error(R.drawable.zhibo_house).into(imageView);
    }
}
