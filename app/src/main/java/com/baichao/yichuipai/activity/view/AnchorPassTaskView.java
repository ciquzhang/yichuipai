package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.AnchorPassTaskBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface AnchorPassTaskView {
    void showToast(String msg);
    void refreshSuccessful(List<AnchorPassTaskBean.DataBean.PageDataBean> data);
    void loadMoreSuccessful(List<AnchorPassTaskBean.DataBean.PageDataBean> data);
}
