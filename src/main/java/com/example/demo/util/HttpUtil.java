package com.example.demo.util;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import lombok.SneakyThrows;

import java.io.IOException;

public class HttpUtil {
    public String getRequestWithOutToken(String url, RequestBody body) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
