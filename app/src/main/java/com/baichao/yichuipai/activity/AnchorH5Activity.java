package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityAnchorH5Binding;
import com.baichao.yichuipai.utils.Constant;

public class AnchorH5Activity extends BaseActivity {

    private ActivityAnchorH5Binding binding;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anchor_h5);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        int anchorTaskId = getIntent().getIntExtra("anchorH5", -1);
        binding.anchorH5.getSettings().setUseWideViewPort(true);
        binding.anchorH5.getSettings().setLoadWithOverviewMode(true);
        binding.anchorH5.getSettings().setJavaScriptEnabled(true);
        binding.anchorH5.loadUrl(Constant.APP_ANCHORH5 + "?anchorTaskId=" + anchorTaskId);
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 开始直播
         */
        binding.anchorToLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
