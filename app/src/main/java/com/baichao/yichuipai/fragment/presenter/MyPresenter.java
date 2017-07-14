package com.baichao.yichuipai.fragment.presenter;

/**
 * Created by pll on 2017/6/5.
 */

public interface MyPresenter {
    void refreshToken(String token);
    void getAuthStatus(String userId,int authType);
    void netForMessage(String userId);
}
