package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityApproveByPBinding;
import com.baichao.yichuipai.utils.Constant;

public class ApproveByPActivity extends BaseActivity {

    private ActivityApproveByPBinding binding;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_approve_by_p);
    }

    @Override
    protected void initListener() {
        super.initListener();

        /**
         * 返回
         */
        binding.approveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
         * 开始实名认证
         */
        binding.approveImpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(mContext,ApproveByPImplActivity.class), Constant.REQUEST_APPROVE_P);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Constant.RESULT_APPROVE_P){
            finish();
        }
    }
}
