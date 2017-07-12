package com.baichao.yichuipai.fragment.view;

import com.baichao.yichuipai.fragment.moudule.AppliedListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface AuAppliedView {
    void showToast(String msg);
    void refreshSuccessful(List<AppliedListBean.DataBean.PageDataBean> data);
    void loadMoreSuccessful(List<AppliedListBean.DataBean.PageDataBean> data);
}
