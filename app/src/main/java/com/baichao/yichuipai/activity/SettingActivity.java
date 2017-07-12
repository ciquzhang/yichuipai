package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivitySettingBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;

public class SettingActivity extends BaseActivity {

    private ActivitySettingBinding binding;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
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
        binding.settingReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 退出登录
         */
        binding.settingExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACache.get(mContext).put("token","");
                ACache.get(mContext).put("token_past_time","");
                ACache.get(mContext).put("userId","");
                setResult(Constant.RESULT_SETTING);
                Toast.makeText(SettingActivity.this, "退出登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
