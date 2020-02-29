package com.tatelucky.yduts.http;

import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author tangsheng
 * @since 2019-08-06
 */
public class PostExcel {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/tate/Downloads/work/study", "test.xlsx");

        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(30, TimeUnit.SECONDS).build();

        MediaType mediaType = MediaType.parse("multipart/form-data; charset=utf-8");

        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        MultipartBody body = new MultipartBody.Builder()
                .setType(mediaType)
                .addFormDataPart("file", "test", fileBody)
                .build();

        Request request = new Request.Builder()
                .url("http://finance-vehicle-disposal.sqaproxy.dasouche-inc.net/importApi/file.json?type=IMPORT_AUCTION")
                .post(body)
                .addHeader("Content-Type", "multipart/form-data")
                .addHeader("cache-control", "no-cache")
                .addHeader("_security_token_inc", "9156507546244342")
                .build();

        okhttp3.Response response = client.newCall(request).execute();
        String result = response.body().string();

        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.get("success"));
        System.out.println(jsonObject.get("msg"));
        System.out.println(jsonObject.get("code"));
    }
}

