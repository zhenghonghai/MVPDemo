package com.example.myweather.ui.activity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myweather.R;
import com.example.myweather.base.BaseActivity;
import com.example.myweather.ui.fragment.PlaceFragment;

public class MainActivity extends BaseActivity {


    private PlaceFragment mPlaceFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        // 创建fragment
        mPlaceFragment = new PlaceFragment();
        initFragment();
    }

    private void initFragment() {
        // 获得fragmentManager
        mFragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.home, mPlaceFragment);
        // 提交事务
        transaction.commit();
    }


}
