package com.baichao.yichuipai.activity.presenter;

/**
 * Created by Administrator on 2017/6/29.
 */

public interface SignUpPresenter {
    void netForSignUp(String userId,String auctionId,String realName,String nationalId,String region,String street,String depositId);
    void netForDeposit(String userId,String regionId,String amount);
}
