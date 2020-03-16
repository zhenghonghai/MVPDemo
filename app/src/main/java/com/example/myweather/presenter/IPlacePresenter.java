package com.example.myweather.presenter;

import com.example.myweather.view.IProvinceCallbask;

public interface IPlacePresenter {

    void getProvinList();

    void registerViewCallback(IProvinceCallbask callback);

    void unRegisterViewCallback(IProvinceCallbask callback);
}
