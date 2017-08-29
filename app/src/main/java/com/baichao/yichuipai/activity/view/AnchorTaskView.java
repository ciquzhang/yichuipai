package com.baichao.yichuipai.activity.view;

import com.baichao.yichuipai.activity.module.AnchorTaskBean;

/**
 * Created by Administrator on 2017/8/24.
 */

public interface AnchorTaskView {
    void showToast(String msg);
    void getListSuccess(AnchorTaskBean.DataBean data);
    void getListNull();
}
