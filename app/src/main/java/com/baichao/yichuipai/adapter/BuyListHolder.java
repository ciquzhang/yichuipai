package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.BuyListBean;
import com.baichao.yichuipai.utils.DateUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/10.
 */

public class BuyListHolder extends BaseViewHolder<BuyListBean.DataBean.PageDataBean> {

    private Context context;
    private LinearLayout buy_list_top;
    private TextView top_id;
    private TextView top_price;
    private TextView top_time;
    private RelativeLayout buy_list_min;
    private LinearLayout buy_list_bottom;
    private TextView bottom_id;
    private TextView bottom_time;
    private TextView bottom_price;

    public BuyListHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.item_buy_list);
        this.context = context;
        buy_list_top = $(R.id.buy_list_top);
        top_id = $(R.id.top_id);
        top_price = $(R.id.top_price);
        top_time = $(R.id.top_time);
        buy_list_min = $(R.id.buy_list_min);
        buy_list_bottom = $(R.id.buy_list_bottom);
        bottom_id = $(R.id.bottom_id);
        bottom_time = $(R.id.bottom_time);
        bottom_price = $(R.id.bottom_price);
    }

    @Override
    public void setData(BuyListBean.DataBean.PageDataBean data) {
        super.setData(data);
        if(data.getPosition() == 0){
            buy_list_top.setVisibility(View.VISIBLE);
            buy_list_min.setVisibility(View.VISIBLE);
            buy_list_bottom.setVisibility(View.GONE);
            top_id.setText(data.getBidNo());
            top_price.setText(data.getPrice()+"");
            top_time.setText(DateUtil.getDateToString(data.getBidTime()));
        }else{
            buy_list_top.setVisibility(View.GONE);
            buy_list_min.setVisibility(View.GONE);
            buy_list_bottom.setVisibility(View.VISIBLE);
            bottom_id.setText(data.getBidNo());
            bottom_price.setText(data.getPrice()+"");
            bottom_time.setText(DateUtil.getDateToString(data.getBidTime()));
        }
    }
}
