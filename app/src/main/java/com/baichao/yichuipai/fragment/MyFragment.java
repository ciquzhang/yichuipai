package com.baichao.yichuipai.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.ApproveByPActivity;
import com.baichao.yichuipai.activity.ApprovebyCActivity;
import com.baichao.yichuipai.activity.AttentionActivity;
import com.baichao.yichuipai.activity.InformationActivity;
import com.baichao.yichuipai.activity.LoginActivity;
import com.baichao.yichuipai.activity.SettingActivity;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.databinding.FragMyBinding;
import com.baichao.yichuipai.fragment.presenter.MyPresenterImpl;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.TimeUtils;
import com.bumptech.glide.Glide;

/**
 * Created by pll on 2017/5/4.
 */

public class MyFragment extends BaseFragment{

    private FragMyBinding binding;
    private MyPresenterImpl presenter;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_my, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new MyPresenterImpl(mActivity);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 登录或者注册
         */
        binding.fragMyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TimeUtils.tokenIsPast(mActivity,presenter)){
                    startActivityForResult(new Intent(mActivity,InformationActivity.class), Constant.REQUEST_CHANGE_INFORMATION);
                }else{
                    startActivityForResult(new Intent(mActivity,LoginActivity.class), Constant.REQUEST_LOGIN);
                }
            }
        });

        /**
         * 关注
         */
        binding.fragMyAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        /**
         * 实名认证
         */
        binding.fragMyApprovePerson.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if(TimeUtils.tokenIsPast(mActivity,presenter)){
                    startActivityForResult(new Intent(mActivity,ApproveByPActivity.class),Constant.REQUEST_APPROVE_P);
                }else{
                    Toast.makeText(mActivity, "请先登录", Toast.LENGTH_SHORT).show();
                    startActivityForResult(new Intent(mActivity,LoginActivity.class), Constant.REQUEST_LOGIN);
                }
            }
        });

        /**
         * 企业认证
         */
        binding.fragMyApproveCompany.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if(TimeUtils.tokenIsPast(mActivity,presenter)){
                    startActivityForResult(new Intent(mActivity,ApprovebyCActivity.class),Constant.REQUEST_APPROVE_C);
                }else{
                    Toast.makeText(mActivity, "请先登录", Toast.LENGTH_SHORT).show();
                    startActivityForResult(new Intent(mActivity,LoginActivity.class), Constant.REQUEST_LOGIN);
                }
            }
        });

        /**
         * 钱包
         */
        binding.fragMyWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TimeUtils.tokenIsPast(mActivity,presenter)){
                    startActivity(new Intent(mActivity,AttentionActivity.class));
                }else{
                    startActivityForResult(new Intent(mActivity,LoginActivity.class), Constant.REQUEST_LOGIN);
                }
            }
        });

        /**
         * 安全性
         */
        binding.fragMySafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        /**
         * 设置
         */
        binding.fragMySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(mActivity,SettingActivity.class),Constant.REQUEST_SETTING);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case Constant.RESULT_LOGIN:
                if(data.getStringExtra("login_name")!=null && data.getStringExtra("login_name").equals("")!=true){
                    binding.fragMyName.setText(data.getStringExtra("login_name"));
                }
                if(data.getStringExtra("login_image")!=null && data.getStringExtra("login_image").equals("")!=true){
                    Glide.with(mActivity).load(data.getStringExtra("login_image")).into(binding.fragMyImg);
                }
                break;

            case Constant.RESULT_SETTING:
                binding.fragMyImg.setBackgroundResource(R.drawable.touxiang);
                binding.fragMyName.setText("未登录");
                binding.fragMyMsg.setText("个人信息");
                binding.fragMyTvApprovePerson.setText("未认证");
                binding.fragMyTvApproveCompany.setText("未认证");
                break;
        }
    }
}
