package com.baichao.yichuipai.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.ApproveByCImplPresenterImpl;
import com.baichao.yichuipai.activity.view.ApproveByCView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityApproveByCimplBinding;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.TimeUtils;

import java.util.ArrayList;

public class ApproveByCimplActivity extends BaseActivity implements ApproveByCView {

    private ActivityApproveByCimplBinding binding;
    private ApproveByCImplPresenterImpl presenter;
    private static final int REQUEST_TAKE_PHOTO_PERMISSION = 200;
    private ArrayList<String> list;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_approve_by_cimpl);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new ApproveByCImplPresenterImpl(mContext,this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();

        /**
         * 上传材料证明
         */
        binding.materialPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ApproveByCimplActivity.this,
                        android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
                    Log.e("TAG", "--需要加权限---");
                    ActivityCompat.requestPermissions(ApproveByCimplActivity.this,
                            new String[]{android.Manifest.permission.CAMERA},
                            REQUEST_TAKE_PHOTO_PERMISSION);
                } else {
                    //有权限，直接拍照
                    Log.e("TAG", "--不需要权限---");
                    startActivityForResult(new Intent(mContext,CMaterialActivity.class), Constant.REQUEST_APPROVE_C_INFORMATION);
                }
            }
        });

        /**
         *  提交审核
         */
        binding.materialCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.netApproveByC(list, TimeUtils.getId(mContext),binding.materialCompanyName.getText().toString(),
                        binding.materialNumber.getText().toString(),binding.materialName.getText().toString(),
                        binding.materialJob.getText().toString(),binding.materialPhone.getText().toString(),
                        binding.materialEmail.getText().toString());
            }
        });

        /**
         * 返回
         */
        binding.materialBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Constant.REQUEST_APPROVE_C_INFORMATION:
                if(resultCode == Constant.RESULT_PICTURE){
                    binding.implImg.setText("已上传");
                    list = data.getExtras().getStringArrayList("approve_c");
                }
                break;
        }
    }


    @SuppressLint("WrongConstant")
    @Override
    public void showToast(String msg) {
        Toast.makeText(ApproveByCimplActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void commitSucceed() {
        setResult(Constant.RESULT_APPROVE_C);
        finish();
    }
}
