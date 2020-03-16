package com.example.myweather.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("china")
    Call<List<Province>> getProvinList();

}
