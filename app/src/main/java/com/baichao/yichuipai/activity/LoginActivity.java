package com.baichao.yichuipai.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.LoginPresenterImpl;
import com.baichao.yichuipai.activity.view.LoginView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityLoginBinding;
import com.baichao.yichuipai.utils.Constant;

public class LoginActivity extends BaseActivity implements LoginView {
    private ActivityLoginBinding binding;
    private LoginPresenterImpl presenter;
    //广播
    private BroadcastReceiver mBroadcastReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new LoginPresenterImpl(this,mContext);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 注册
         */
        binding.loginToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,RegisterActivity.class));
            }
        });

        /**
         * 忘记密码
         */
        binding.loginForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,ForgotPasswordActivity.class));
            }
        });

        /**
         * 登录
         */
        binding.loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.loginPhone.getText().toString();
                String password = binding.loginPassword.getText().toString();
                presenter.loginCommit(phone,password);
            }
        });

        /**
         * 返回
         */
        binding.loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful() {
        setResult(Constant.RESULT_LOGIN);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mBroadcastReceiver);
    }
}
