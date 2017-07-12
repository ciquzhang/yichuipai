package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.DepositBean;
import com.baichao.yichuipai.utils.DateUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DepositHolder extends BaseViewHolder<DepositBean.DataBean> {

    private Context context;
    private TextView deposit_price;
    private TextView deposit_time;
    private TextView deposit_type;

    public DepositHolder(ViewGroup parent,Context context) {
        super(parent, R.layout.item_deposit);
        this.context = context;
        deposit_price = $(R.id.deposit_price);
        deposit_time = $(R.id.deposit_time);
        deposit_type = $(R.id.deposit_type);
    }

    @Override
    public void setData(DepositBean.DataBean data) {
        super.setData(data);
        //价钱
        deposit_price.setText("￥" + data.getAmount());
        //创建时间
        deposit_time.setText("(" + DateUtil.getDateToString(data.getCreateTime()) + " 充值)");
        //资金状态
        if(data.getDepositStatus() == 0){
            deposit_type.setText("闲置");
        }else{
            deposit_type.setText("冻结");
        }
    }
}
