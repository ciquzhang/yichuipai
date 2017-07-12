package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.fragment.moudule.AppliedListBean;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.Utils;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/7/3.
 */

public class AppliedHolder extends BaseViewHolder<AppliedListBean.DataBean.PageDataBean.HouseAndSignRecordBean> {

    private Context context;
    private TextView applied_type;
    private TextView applied_id;
    private TextView applied_title;
    private TextView applied_price_type;
    private TextView applied_price;
    private TextView applied_sign_up_count;
    private TextView applied_price_count;
    private TextView applied_look_count;
    private Button applied_look;
    private ImageView applied_image;


    public AppliedHolder(ViewGroup parent,Context context) {
        super(parent, R.layout.item_applied);
        this.context = context;
        applied_type = $(R.id.applied_type);
        applied_id = $(R.id.applied_id);
        applied_title = $(R.id.applied_title);
        applied_price_type = $(R.id.applied_price_type);
        applied_price = $(R.id.applied_price);
        applied_sign_up_count = $(R.id.applied_sign_up_count);
        applied_price_count = $(R.id.applied_price_count);
        applied_look_count = $(R.id.applied_look_count);
        applied_look = $(R.id.applied_look);
        applied_image = $(R.id.applied_image);
    }

    @Override
    public void setData(AppliedListBean.DataBean.PageDataBean.HouseAndSignRecordBean data) {
        super.setData(data);
        if(data.getAuctionInfo().getAuctionStatus() == 2 && data.getAuctionInfo().getLiveStatus() == 1 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //拍卖中
            applied_type.setText("拍卖中");
            applied_type.setBackgroundResource(R.drawable.collection_shape_1);
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 0 && data.getHouseInfo().getSeeHouseStatus()==0){
            //无状态
            applied_type.setText("已结束");
        }else if(data.getAuctionInfo().getAuctionStatus() == 0 && data.getAuctionInfo().getLiveStatus() == 0 &&
                data.getAuctionInfo().getSignStatus() == 1 && data.getHouseInfo().getSeeHouseStatus()==0){
            //报名中
            applied_type.setText("报名中");
            applied_type.setBackgroundResource(R.drawable.collection_shape_2);
        }else if(data.getAuctionInfo().getSignStatus() == 1 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            applied_type.setText("看房中");
            applied_type.setBackgroundResource(R.drawable.collection_shape_3);
        }else if(data.getAuctionInfo().getSignStatus() == 0 && data.getAuctionInfo().getAuctionStatus() == 0 &&
                data.getAuctionInfo().getLiveStatus() == 1 && data.getHouseInfo().getSeeHouseStatus() == 1){
            //看房中
            applied_type.setText("看房中");
            applied_type.setBackgroundResource(R.drawable.collection_shape_3);
        }
        if(data.getAuctionInfo().getAuctionStatus()==2){
            applied_price_type.setText("当前价");
            applied_price.setText(Utils.nullToString(data.getAuctionInfo().getCurrentPrice()));
        }else{
            applied_price_type.setText("评估价");
            applied_price.setText(Utils.nullToString(data.getHouseInfo().getEvalautePrice()));
        }
        //竞买号
        applied_id.setText("竞买号[" + data.getAuctionSignRecord().getBidNo() + "]");
        //标题
        applied_title.setText("[" + data.getName() + "]" + data.getHouseInfo().getTitle());
        //报名
        applied_sign_up_count.setText(data.getAuctionInfo().getBidCount()+"人报名");
        //提醒人数
        applied_price_count.setText(data.getAuctionInfo().getCollectionCount()+"人设置提醒");
        //围观
        applied_look_count.setText(data.getHouseInfo().getPv()+"次围观");
        //icon
        Glide.with(context).load(Constant.APP_IMAGE + data.getHouseInfo().getImgUrl()).error(R.drawable.zhibo_house).into(applied_image);
        applied_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "查看拍卖确认书", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
