package com.exercise.zhufangda.androidexercise.retrofit;

import com.exercise.zhufangda.androidexercise.BuildConfig;
import com.exercise.zhufangda.androidexercise.network.LiveDataCallAdapterFactory;
import com.exercise.zhufangda.androidexercise.network.OgemrayService;
import com.exercise.zhufangda.androidexercise.network.RetrofitClient;
import com.exercise.zhufangda.androidexercise.network.SOService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static final String OG_URL = "http://papi.ogemray-server.com/";
    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).crndoideate(SOService.class);
    }

    public static OgemrayService getOgService() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)//设置超时时间
                .retryOnConnectionFailure(true);

        client.addInterceptor(logInterceptor);

        return new Retrofit.Builder().baseUrl(OG_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build().create(OgemrayService.class);
    }

}
