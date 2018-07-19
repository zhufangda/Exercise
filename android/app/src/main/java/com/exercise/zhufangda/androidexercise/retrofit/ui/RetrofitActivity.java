package com.exercise.zhufangda.androidexercise.retrofit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.exercise.zhufangda.androidexercise.R;

import com.exercise.zhufangda.androidexercise.retrofit.ApiUtils;
import com.exercise.zhufangda.androidexercise.retrofit.data.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.exercise.zhufangda.androidexercise.network.AnswersAdapter;
import com.exercise.zhufangda.androidexercise.network.SOAnswersResponse;
import com.exercise.zhufangda.androidexercise.network.SOService;

public class RetrofitActivity extends AppCompatActivity {
    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_retrofit );
        mService = ApiUtils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(RetrofitActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                showErrorMessage(t.getMessage());
                Log.d("MainActivity", "error loading from API");

            }
        });
    }



    void showErrorMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG);
    }
}
