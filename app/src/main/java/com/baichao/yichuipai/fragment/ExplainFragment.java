package com.baichao.yichuipai.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.core.BaseFragment;
import com.baichao.yichuipai.databinding.FragExplainBinding;

/**
 * Created by Administrator on 2017/8/23.
 */

public class ExplainFragment extends BaseFragment{

    private FragExplainBinding binding;

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_explain, container, false);
        return binding.getRoot();
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
    }
}
