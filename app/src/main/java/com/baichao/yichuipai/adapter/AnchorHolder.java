package com.baichao.yichuipai.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.AnchorPassTaskBean;
import com.baichao.yichuipai.utils.DateUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/8/25.
 */

public class AnchorHolder  extends BaseViewHolder<AnchorPassTaskBean.DataBean.PageDataBean> {

    private Context context;
    private TextView title;
    private TextView content;

    public AnchorHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.item_anchor_today);
        this.context = context;
        title = $(R.id.anchor_today_title);
        content = $(R.id.anchor_today_content);
    }

    @Override
    public void setData(AnchorPassTaskBean.DataBean.PageDataBean data) {
        super.setData(data);
        title.setText("[" + DateUtil.getDateToAnchorString(data.getBeginTime()) + "]" + data.getTaskName());
        content.setText(data.getTaskDesc());
    }
}
