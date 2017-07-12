package com.baichao.yichuipai.activity.presenter;

import java.util.ArrayList;

/**
 * Created by pll on 2017/6/5.
 */

public interface ApproveByCImplPresenter {
    void netApproveByC(ArrayList<String> list, String userId,String companyName,String licenseNo,
                       String personName,String personPosition,String personMobile,String personEmail);
}
