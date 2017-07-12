package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.RegisterPresenterImpl;
import com.baichao.yichuipai.activity.view.RegisterView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity implements RegisterView{

    private ActivityRegisterBinding binding;
    private RegisterPresenterImpl presenter;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new RegisterPresenterImpl(this,mContext);
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
        binding.registerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
         * 确认注册
         */
        binding.registerCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.registerPhone.getText().toString();
                String code = binding.registerCode.getText().toString();
                String password = binding.registerPassword.getText().toString();
                presenter.registerCommit(phone,code,password);
            }
        });

        /**
         * 获取验证码
         */
        binding.registerGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.registerGetCode(binding.registerPhone.getText().toString());
            }
        });

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishView() {
        this.finish();
    }
}
