package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity {
    private ActivityForgotPasswordBinding binding;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();

        /**
         * 返回
         */
        binding.forgotPasswordBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
         * 确认修改
         */
        binding.forgotPasswordCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /**
         * to邮箱修改
         */
        binding.forgotPasswordToEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,CgPsByEmailActivity.class));
            }
        });
    }
}
