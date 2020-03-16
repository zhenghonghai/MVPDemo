package com.example.myweather.ui.fragment;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweather.R;
import com.example.myweather.base.BaseFragment;
import com.example.myweather.model.Province;
import com.example.myweather.presenter.IPlacePresenter;
import com.example.myweather.presenter.impl.PlacePresenterImpl;
import com.example.myweather.ui.adapter.PlaceAdapter;
import com.example.myweather.utils.LogUtils;
import com.example.myweather.view.IProvinceCallbask;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends BaseFragment implements IProvinceCallbask {

    private RecyclerView mPlace;
    private PlaceAdapter mPlaceAdapter;
    private IPlacePresenter mPlacePresenter;

    @Override
    protected int getLayoutInflaterResId() {
        return R.layout.fragment_place;
    }

    @Override
    protected void initView(View rootView) {
        mPlace = rootView.findViewById(R.id.place);
        // 创建布局管理器
        mPlace.setLayoutManager(new LinearLayoutManager(getContext()));
        mPlaceAdapter = new PlaceAdapter();
        // 创建适配器
        mPlace.setAdapter(mPlaceAdapter);
    }

    @Override
    protected void initPresenter() {
        // TODO: 创建 PlacePresenter 对象
        mPlacePresenter = new PlacePresenterImpl();
        mPlacePresenter.registerViewCallback(this);
    }

    @Override
    protected void loadData() {
        mPlacePresenter.getProvinList();
    }

    @Override
    public void loadedData(List<Province> provinceList) {
        // 数据从这里回来
        LogUtils.d(this,  "loadedData" + provinceList.toString());
        if (provinceList != null) {
            mPlaceAdapter.setmData(provinceList);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlacePresenter != null) {
            mPlacePresenter.unRegisterViewCallback(this);
        }
    }
}
