package com.exercise.zhufangda.androidexercise.retrofit.ui;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.exercise.zhufangda.androidexercise.R;
import com.exercise.zhufangda.androidexercise.network.ApiResponse;
import com.exercise.zhufangda.androidexercise.retrofit.ApiUtils;

import com.exercise.zhufangda.androidexercise.retrofit.data.BaseResponse;

import com.exercise.zhufangda.androidexercise.network.OgemrayService;
import com.exercise.zhufangda.androidexercise.network.UserInfoResponse;

public class GetUserActivity extends AppCompatActivity {
    private OgemrayService mService;
    TextView tv;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_get_user);
        mService = ApiUtils.getOgService();

        tv = findViewById(R.id.textView);
        loadAnswers();
    }

    public void loadAnswers() {
        mService.getUserInfo("a4b280453c434bd39dd8b07afd003b5", 1183481).observe(this, new Observer<ApiResponse<BaseResponse<UserInfoResponse>>>() {
            @Override
            public void onChanged(@Nullable ApiResponse<BaseResponse<UserInfoResponse>> baseResponseApiResponse) {
                if(baseResponseApiResponse.isSuccessful()){
                    tv.setText(String.valueOf(baseResponseApiResponse.getBody().getData().getUID()));
                }else{
                    tv.setText(String.valueOf(baseResponseApiResponse.getCode()));
                }

            }
        });
    }



    void showErrorMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG);
    }
}
