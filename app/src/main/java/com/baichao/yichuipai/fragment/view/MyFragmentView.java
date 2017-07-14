package com.baichao.yichuipai.fragment.view;

/**
 * Created by Administrator on 2017/7/14.
 */

public interface MyFragmentView {
    void showToast(String msg);
    void isAuth(String isAuth,int type);
    void setUserMessage(String personStatus,String companyStatus,String name,String headImg);
}
