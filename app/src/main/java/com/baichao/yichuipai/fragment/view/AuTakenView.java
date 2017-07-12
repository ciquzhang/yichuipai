package com.baichao.yichuipai.fragment.view;

import com.baichao.yichuipai.fragment.moudule.TakenListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface AuTakenView {
    void showToast(String msg);
    void refreshSuccessful(List<TakenListBean.DataBean.PageDataBean> data);
    void loadMoreSuccessful(List<TakenListBean.DataBean.PageDataBean> data);
}
