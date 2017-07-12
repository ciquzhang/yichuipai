package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.OfferPresenter;
import com.baichao.yichuipai.activity.presenter.OfferPresenterImpl;
import com.baichao.yichuipai.activity.view.OfferView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityOfferBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;

public class OfferActivity extends BaseActivity implements OfferView {

    private ActivityOfferBinding binding;
    private OfferPresenter presenter;
    private String price;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offer);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new OfferPresenterImpl(mContext,this);
        binding.offerTitle.setText(getIntent().getStringExtra("title"));
        binding.offerCurrentPrice.setText(getIntent().getStringExtra("currentPrice"));
        price = getIntent().getStringExtra("currentPrice");
        binding.offerPriceAdd.setText("加价幅度  " + getIntent().getStringExtra("increasePrice"));
        binding.offerPriceAssessment.setText("评估价  " + getIntent().getStringExtra("evalautePrice"));
        binding.offerNumber.setText(getIntent().getStringExtra("bidNo"));
        binding.offerPrice.setText(getIntent().getStringExtra("currentPrice"));
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
        binding.offerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 减少
         */
        binding.offerReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.reduce(price,getIntent().getStringExtra("increasePrice"),getIntent().getStringExtra("currentPrice"));
            }
        });

        /**
         * 增加
         */
        binding.offerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.add(price,getIntent().getStringExtra("increasePrice"));
            }
        });

        /**
         * 出价
         */
        binding.offerCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(binding.offerPrice.getText().toString()) <= Integer.parseInt(getIntent().getStringExtra("currentPrice"))){
                    showToast("出价必须大于当前价");
                    return;
                }
                presenter.offerPrice(getIntent().getStringExtra("auctionId"),
                        ACache.get(mContext).getAsString("userId"),price,getIntent().getStringExtra("bidNo"));
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPrice(String price) {
        binding.offerPrice.setText(price);
        this.price = price;
    }

    @Override
    public void offerSuccess() {
        setResult(Constant.RESULT_LOGIN);
        finish();
    }
}
