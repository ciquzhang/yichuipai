package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.fragment.moudule.TakenListBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/3.
 */

public class TakenHolder extends BaseViewHolder<TakenListBean.DataBean.PageDataBean> {

    private Context context;
    private TextView taken_id;
    private TextView taken_pay;
    private TextView taken_title;
    private TextView taken_price_type;
    private TextView taken_price;
    private TextView taken_sign_up_count;
    private TextView taken_price_count;
    private TextView taken_look_count;
    private Button taken_look;
    private ImageView taken_image;

    public TakenHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.item_taken);
        this.context = context;
        taken_id = $(R.id.taken_id);
        taken_pay = $(R.id.taken_pay);
        taken_title = $(R.id.taken_title);
        taken_price_type = $(R.id.taken_price_type);
        taken_price = $(R.id.taken_price);
        taken_sign_up_count = $(R.id.taken_sign_up_count);
        taken_price_count = $(R.id.taken_price_count);
        taken_look_count = $(R.id.taken_look_count);
        taken_look = $(R.id.taken_look);
        taken_image = $(R.id.taken_image);
    }

    @Override
    public void setData(TakenListBean.DataBean.PageDataBean data) {
        super.setData(data);
        //竞买号
        taken_id.setText("[竞买号 " + data.getAuctionRecord().getBidNo() + "]");
        //未支付或者已支付
        if(data.getAuctionResult().getTranStatus() == 1){
            taken_pay.setText("未支付");
        }else if(data.getAuctionResult().getTranStatus() == 2){
            taken_pay.setText("交易成功");
            taken_pay.setTextColor(Color.parseColor("#00B589"));
        }else if(data.getAuctionResult().getTranStatus() == 3){
            taken_pay.setText("支付失败");
        }
        //标题
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00b589"));
        SpannableStringBuilder builder = new SpannableStringBuilder("[" + data.getAuctionMeeting().getName() + "]" + data.getHouseInfo().getTitle());
        builder.setSpan(span, 0, data.getAuctionMeeting().getName().length()+2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        taken_title.setText(builder);

        //成交价
        taken_price.setText(Utils.nullToString(data.getAuctionInfo().getCurrentPrice()));
        //报名
        taken_sign_up_count.setText(data.getAuctionMeeting().getSignCount()+"人报名");
        //出价
        taken_price_count.setText(data.getCountRecord()+"人出价");
        //围观
        taken_look_count.setText(data.getHouseInfo().getPv()+"次围观");
        taken_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, taken_look.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context).load(Constant.APP_IMAGE + data.getHouseInfo().getImgUrl()).error(R.drawable.zhibo_house).into(taken_image);

    }
}
