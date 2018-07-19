package com.exercise.zhufangda.androidexercise.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.exercise.zhufangda.androidexercise.R;
import com.exercise.zhufangda.androidexercise.network.AnswersAdapter;
import com.exercise.zhufangda.androidexercise.network.SOAnswersResponse;
import com.exercise.zhufangda.androidexercise.network.SOService;
import com.exercise.zhufangda.androidexercise.retrofit.ApiUtils;
import com.exercise.zhufangda.androidexercise.retrofit.data.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );


    }

}
