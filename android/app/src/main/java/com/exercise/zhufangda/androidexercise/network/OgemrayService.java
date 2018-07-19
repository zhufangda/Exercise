package com.exercise.zhufangda.androidexercise.network;

import android.arch.lifecycle.LiveData;


import com.exercise.zhufangda.androidexercise.retrofit.data.BaseResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OgemrayService {
    @FormUrlEncoded
    @POST("Account/GetInfo")
    LiveData<ApiResponse<BaseResponse<UserInfoResponse>>> getUserInfo(@Field("Token") String token, @Field("uid") int uid);
}
