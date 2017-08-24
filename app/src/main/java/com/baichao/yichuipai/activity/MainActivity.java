package com.baichao.yichuipai.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.Toast;

import com.baichao.yichuipai.R;
import com.baichao.yichuipai.activity.presenter.MainPresenterImpl;
import com.baichao.yichuipai.activity.view.MainView;
import com.baichao.yichuipai.adapter.MainTabContainerAdapter;
import com.baichao.yichuipai.core.BaseActivity;
import com.baichao.yichuipai.databinding.ActivityMainBinding;
import com.baichao.yichuipai.fragment.AuctionListFragment;
import com.baichao.yichuipai.fragment.ExplainFragment;
import com.baichao.yichuipai.fragment.HomeFragment;
import com.baichao.yichuipai.fragment.MyFragment;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.StatusColorUtils;

public class MainActivity extends BaseActivity implements MainView{

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private MainPresenterImpl presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void loadContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        presenter = new MainPresenterImpl(this);
        StatusColorUtils.initSystemBar(this,"#00b589");
    }

    @Override
    protected void initData() {
        super.initData();
        /**
         * 是否需要更新
         */
        presenter.isNeedDownLoadApk();

        /**
         * 底部选择器的设置
         */
        binding.tabContainer.setAdapter(new MainTabContainerAdapter(getSupportFragmentManager(),
                new Fragment[] {new HomeFragment(), new ExplainFragment(), new AuctionListFragment(), new MyFragment()}));
        binding.tabContainer.setCurrentItem(0);

    }

    @Override
    public void showDownLoadDia() {
        // 构造对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("软件更新");
        builder.setMessage("有更新的版本哦。。。");
        // 更新
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                // 显示下载对话框
                presenter.downLoadApk("需要下载的apk地址");

            }
        });

        // 稍后更新
        builder.setNegativeButton("稍后更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 两次退出
         */
        if(keyCode == KeyEvent.KEYCODE_BACK){
            presenter.exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Constant.RESULT_LIVE_TO_MY){
            binding.tabContainer.setCurrentItem(3);
        }
    }
}
