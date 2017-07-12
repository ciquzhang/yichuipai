package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.MeetingListBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MeetingHolder extends BaseViewHolder<MeetingListBean.DataBean> {


    private TextView type;
    private ImageView imageView;
    private TextView title;
    private TextView price;
    private TextView count;
    private TextView price_type;
    private Context context;

    public MeetingHolder(ViewGroup parent,Context context) {
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
    public void setData(MeetingListBean.DataBean data) {
        super.setData(data);
        price_type.setText("起拍价");
        type.setVisibility(View.GONE);
        price.setText(Utils.nullToString(data.getStartPrice()));
        title.setText(Utils.nullToString(data.getTitle()));
        count.setText(Utils.nullToString(data.getPv()));
        imageView.setBackgroundResource(R.drawable.home_bg_shape);
        Glide.with(context).load(Constant.APP_IMAGE + data.getImgUrl()).error(R.drawable.zhibo_house).into(imageView);

    }
}
