package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.MeetingListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface AuctionMeetingView {
    void showToast(String msg);
    void refreshSuccess(List<MeetingListBean.DataBean> data);
}
