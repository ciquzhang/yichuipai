package com.baichao.yichuipai.fragment.view;

import com.baichao.yichuipai.fragment.moudule.CollectionListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public interface AuCollectView {
    void showToast(String msg);
    void refreshSuccessful(List<CollectionListBean.DataBean.PageDataBean> data);
    void loadMoreSuccessful(List<CollectionListBean.DataBean.PageDataBean> data);
}
