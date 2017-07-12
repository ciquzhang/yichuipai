package com.baichao.yichuipai.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityTextBinding;
import com.baichao.yichuipai.utils.Constant;

public class TextActivity extends BaseActivity {

    private ActivityTextBinding binding;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text);
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 返回
         */
        binding.textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
         * 保存
         */
        binding.textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("text_input",binding.textInput.getText().toString());
                setResult(Constant.RESULT_PICTURE,intent);
                finish();
            }
        });
    }


}
