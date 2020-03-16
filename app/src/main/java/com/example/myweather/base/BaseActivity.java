package com.example.myweather.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView();
        initListener();
    }

    /**
     * 监听事件
     */
    protected void initListener() {
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 获取Layout.xml的Id
     * @return
     */
    protected abstract int getLayoutResId();
}
