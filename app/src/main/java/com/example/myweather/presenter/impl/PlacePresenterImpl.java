package com.example.myweather.presenter.impl;

import com.example.myweather.model.Api;
import com.example.myweather.model.Province;
import com.example.myweather.presenter.IPlacePresenter;
import com.example.myweather.utils.LogUtils;
import com.example.myweather.utils.RetrofitManager;
import com.example.myweather.view.IProvinceCallbask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlacePresenterImpl implements IPlacePresenter {

    private IProvinceCallbask mCallbask = null;
    @Override
    public void getProvinList() {

        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<List<Province>> task = api.getProvinList();
        task.enqueue(new Callback<List<Province>>() {
            @Override
            public void onResponse(Call<List<Province>> call, Response<List<Province>> response) {
                LogUtils.d(this, " onResponse ==>  " + " 请求成功");
                LogUtils.d(this, response.body().toString());
                if (mCallbask != null && !response.body().isEmpty()) {
                    mCallbask.loadedData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Province>> call, Throwable t) {
                LogUtils.d(this, "请求失败" + t.toString());
            }
        });


    }

    @Override
    public void registerViewCallback(IProvinceCallbask callback) {
        mCallbask = callback;
    }

    @Override
    public void unRegisterViewCallback(IProvinceCallbask callback) {
        mCallbask = null;

    }
}
