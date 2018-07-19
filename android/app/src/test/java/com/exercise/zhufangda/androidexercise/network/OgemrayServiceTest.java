package com.exercise.zhufangda.androidexercise.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.exercise.zhufangda.androidexercise.retrofit.data.BaseResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class OgemrayServiceTest {


    private OgemrayService service;

    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();

        service = new Retrofit.Builder().baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build().create(OgemrayService.class);

    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    public void getUserInfo() throws IOException, InterruptedException {
        enqueueResponse("getuser.json");
        ApiResponse<BaseResponse<UserInfoResponse>> body = null;
        body = getValue(service.getUserInfo("f9289a7acb254acb8e8165fa7096a220", 1130105));


        RecordedRequest request = mockWebServer.takeRequest();

        assertThat(request.getPath(), is("/Account/GetInfo"));
        assertThat(body, notNullValue());
        assertThat(body, notNullValue());

//        assertThat(body.getData().getUID(), is(1130105));
//        assertThat(body.getData().getEmail(), is("9008724@qq.com"));
//
//
//        System.out.print(body.getData().getUID());
    }

    private void enqueueResponse(String fileName) throws IOException {
        enqueueResponse(fileName, Collections.<String, String>emptyMap());
    }

    private void enqueueResponse(String fileName, Map<String, String> headers) throws IOException {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("api-response/" + fileName);
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            mockResponse.addHeader(header.getKey(), header.getValue());
        }

        System.out.print(mockResponse);

        mockWebServer.enqueue(mockResponse
                .setBody(source.readString(StandardCharsets.UTF_8)));
    }


    public static <T> T getValue(final LiveData<T> liveData) throws InterruptedException {
        final Object[] data = new Object[1];
        final CountDownLatch latch = new CountDownLatch(1);
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T o) {
                data[0] = o;
                latch.countDown();
                liveData.removeObserver(this);
            }
        };
        liveData.observeForever(observer);
        latch.await(2, TimeUnit.SECONDS);
        //noinspection unchecked
        return (T) data[0];
    }

}