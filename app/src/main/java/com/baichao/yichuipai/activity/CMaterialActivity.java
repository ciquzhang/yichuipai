package com.baichao.yichuipai.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.CMaterialPresenterImpl;
import com.baichao.yichuipai.activity.view.CMaterialView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityCmaterialBinding;
import com.baichao.yichuipai.utils.Constant;

import java.io.File;

import static com.baichao.yichuipai.utils.Constant.CHOOSE_PICTURE_BUSINESS;
import static com.baichao.yichuipai.utils.Constant.CHOOSE_PICTURE_CONTRARY;
import static com.baichao.yichuipai.utils.Constant.CHOOSE_PICTURE_FRONT;
import static com.baichao.yichuipai.utils.Constant.CHOOSE_PICTURE_OTHER;
import static com.baichao.yichuipai.utils.Constant.TAKE_PICTURE_BUSINESS;
import static com.baichao.yichuipai.utils.Constant.TAKE_PICTURE_CONTRARY;
import static com.baichao.yichuipai.utils.Constant.TAKE_PICTURE_FRONT;
import static com.baichao.yichuipai.utils.Constant.TAKE_PICTURE_OTHER;

public class CMaterialActivity extends BaseActivity implements CMaterialView {

    private ActivityCmaterialBinding binding;
    private File file_card_business=null;//营业执照图片文件
    private File file_card_front = null;//身份证正面图片文件
    private File file_card_contrary = null;//身份证反面图片文件
    private File file_card_other = null;//手持身份证图片
    private CMaterialPresenterImpl presenter;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cmaterial);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new CMaterialPresenterImpl(mContext,this);
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
        binding.materialBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
         * 营业执照
         */
        binding.materialLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPicturePicker(mContext,TAKE_PICTURE_BUSINESS,CHOOSE_PICTURE_BUSINESS);
            }
        });

        /**
         * 身份证正面
         */
        binding.materialFrontCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPicturePicker(mContext,TAKE_PICTURE_FRONT,CHOOSE_PICTURE_FRONT);
            }
        });

        /**
         * 身份证反面
         */
        binding.materialContraryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPicturePicker(mContext,TAKE_PICTURE_CONTRARY,CHOOSE_PICTURE_CONTRARY);
            }
        });

        /**
         * 手持身份证照
         */
        binding.materialFaceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPicturePicker(mContext,TAKE_PICTURE_OTHER,CHOOSE_PICTURE_OTHER);
            }
        });

        /**
         * 企业认证确认
         */
        binding.materialCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.netForPicture();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE_FRONT:
                    presenter.showImageByTake(0,file_card_front,binding.companyFrontCardImg);
                    break;
                case CHOOSE_PICTURE_FRONT:
                    presenter.showImageByChoose(0,data,file_card_front,binding.companyFrontCardImg);
                    break;
                case TAKE_PICTURE_CONTRARY:
                    presenter.showImageByTake(1,file_card_contrary,binding.companyContraryCardImg);
                    break;
                case CHOOSE_PICTURE_CONTRARY:
                    presenter.showImageByChoose(1,data,file_card_contrary,binding.companyContraryCardImg);
                    break;
                case TAKE_PICTURE_OTHER:
                    presenter.showImageByTake(2,file_card_other,binding.companyOtherCardImg);
                    break;
                case CHOOSE_PICTURE_OTHER:
                    presenter.showImageByChoose(2,data,file_card_other,binding.companyOtherCardImg);
                    break;
                case TAKE_PICTURE_BUSINESS:
                    presenter.showImageByTake(3,file_card_business,binding.companyBusinessImg);
                    break;
                case CHOOSE_PICTURE_BUSINESS:
                    presenter.showImageByChoose(3,data,file_card_business,binding.companyBusinessImg);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void startActivityByPicture(Intent intent, int pictureType) {
        startActivityForResult(intent,pictureType);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void showToast(String msg) {
        Toast.makeText(CMaterialActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void commitSuccess(Intent intent) {
        setResult(Constant.RESULT_PICTURE,intent);
        finish();
    }
}
