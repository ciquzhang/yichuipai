package com.baichao.yichuipai.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.module.NeedDepositBean;
import com.baichao.yichuipai.activity.presenter.SignUpPresenterImpl;
import com.baichao.yichuipai.activity.view.SignUpView;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivitySignUpBinding;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.DateUtil;
import com.bigkoo.pickerview.OptionsPickerView;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends BaseActivity implements SignUpView {

    private ActivitySignUpBinding binding;
    private OptionsPickerView pvOptions;
    private SignUpPresenterImpl presenter;
    private int depositId = -1;

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new SignUpPresenterImpl(mContext,this);
        binding.signUpNeedPrice.setText("￥" + getIntent().getStringExtra("amount"));
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        /**
         * 地区选择
         */
        binding.signUpChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseTop();
            }
        });

        /**
         * 返回
         */
        binding.signUpReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /**
         * 押金选择
         */
        binding.signUpDepositChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.netForDeposit(ACache.get(mContext).getAsString("userId"),
                        getIntent().getStringExtra("regionId"),
                        getIntent().getStringExtra("amount"));
            }
        });

        /**
         * 报名提交
         */
        binding.signUpCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.signUpCheck1.isChecked() && binding.signUpCheck2.isChecked()){
                    presenter.netForSignUp(ACache.get(mContext).getAsString("userId"),
                            getIntent().getStringExtra("auctionMeetingId"),
                            binding.signUpName.getText().toString(),
                            binding.signUpCard.getText().toString(),
                            binding.signUpChooseTv.getText().toString(),
                            binding.signUpStress.getText().toString(),
                            depositId+"");
                }else{
                    showToast("请选择竞买人条件确认");
                }
            }
        });
    }

    private void showChooseTop() {
        CityPicker cityPicker = new CityPicker.Builder(mContext).textSize(20)
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .cancelTextColor("#999999")
                .province("浙江省")
                .titleBackgroundColor("#f8f8f8")
                .city("杭州市")
                .district("江干区")
                .confirTextColor("#00b589")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .build();
        cityPicker.show();
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                binding.signUpChooseTv.setText(citySelected[0] + "  " + citySelected[1] + "  "
                        + citySelected[2]);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    private void showChooseDialog(final List<String> mlist, final List<Integer> mIntegers) {
        pvOptions = new OptionsPickerView.Builder(mContext, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int i, int i1, int i2, View view) {
                binding.signUpDeposit.setText(mlist.get(i));
                depositId = mIntegers.get(i);
            }
        })
                .setTitleText("押金选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.GRAY)//设置分割线的颜色
                .setSelectOptions(0)//默认选中项
                .setBgColor(Color.WHITE)
                .setTitleBgColor(Color.parseColor("#f8f8f8"))
                .setTitleColor(Color.parseColor("#333333"))
                .setCancelColor(Color.parseColor("#999999"))
                .setSubmitColor(Color.parseColor("#00b589"))
                .setTextColorCenter(Color.parseColor("#333333"))
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setBackgroundId(0x66000000) //设置外部遮罩颜色
                .build();
        pvOptions.setPicker(mlist);//一级选择器*/
        pvOptions.show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signSuccess() {
        setResult(Constant.RESULT_LOGIN);
        finish();
    }

    @Override
    public void depositSuccess(List<NeedDepositBean.DataBean> data) {
        if(data.size() == 0){
            showToast("暂无可用押金");
        }else{
            ArrayList<String> strings = new ArrayList<>();
            ArrayList<Integer> integers = new ArrayList<>();
            for(int i = 0;i<data.size();i++){
                strings.add("￥ " + data.get(i).getAmount() + "(" + DateUtil.getDateToString(data.get(i).getCreateTime()) + "充值)");
                integers.add(data.get(i).getId());
            }
            showChooseDialog(strings,integers);
        }
    }
}
