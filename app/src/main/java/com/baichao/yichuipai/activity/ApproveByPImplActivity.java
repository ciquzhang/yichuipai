package com.baichao.yichuipai.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.ApproveByPImplPresenterImpl;
import com.baichao.yichuipai.activity.view.ApproveByPView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityApproveByPimplBinding;
import com.baichao.yichuipai.utils.Constant;

import java.util.ArrayList;

public class ApproveByPImplActivity extends BaseActivity implements ApproveByPView{
    private ActivityApproveByPimplBinding binding;
    private ApproveByPImplPresenterImpl presenter;
    private ArrayList<String> list;
    private static final int REQUEST_TAKE_PHOTO_PERMISSION = 200;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_approve_by_pimpl);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new ApproveByPImplPresenterImpl(mContext,this);
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
        binding.approveImplInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ApproveByPImplActivity.this,
                        android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
                    Log.e("TAG", "--需要加权限---");
                    ActivityCompat.requestPermissions(ApproveByPImplActivity.this,
                            new String[]{android.Manifest.permission.CAMERA},
                            REQUEST_TAKE_PHOTO_PERMISSION);
                } else {
                    //有权限，直接拍照
                    Log.e("TAG", "--不需要权限---");
                    startActivityForResult(new Intent(mContext,PMaterialActivity.class), Constant.REQUEST_APPROVE_P_INFORMATION);
                }
            }
        });

        /**
         * 提交审核
         */
        binding.approveImplCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.netApproveByP(list,
                        binding.implEdName.getText().toString(),
                        binding.implEdCard.getText().toString());
            }
        });

        /**
         * 返回
         */
        binding.approveImplBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_TAKE_PHOTO_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //申请成功，可以拍照
                startActivityForResult(new Intent(mContext,PMaterialActivity.class), Constant.REQUEST_APPROVE_P_INFORMATION);
            } else {
                Toast.makeText(this, "请手动打开相机权限", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Constant.REQUEST_APPROVE_P_INFORMATION:
                if(resultCode == Constant.RESULT_PICTURE){
                    binding.implImg.setText("已上传");
                    list = data.getExtras().getStringArrayList("approve_p");
                }
                break;
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void showToast(String msg) {
        Toast.makeText(ApproveByPImplActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void commitSucceed() {
        setResult(Constant.RESULT_APPROVE_P);
        finish();
    }
}
