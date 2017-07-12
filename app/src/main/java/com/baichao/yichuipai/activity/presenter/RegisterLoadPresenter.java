package com.baichao.yichuipai.activity.presenter;

/**
 * Created by pll on 2017/5/8.
 */

public interface RegisterLoadPresenter {
    void registerGetCode(String phone);
    void registerCommit(String phone,String code,String password);
}
