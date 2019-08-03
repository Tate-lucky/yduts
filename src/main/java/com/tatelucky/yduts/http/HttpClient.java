package com.tatelucky.yduts.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author tangsheng
 * @since 2019-08-03
 */
public class HttpClient {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"state\":\"{\\\"queryParam\\\":{},\\\"record\\\":{},\\\"tabKey\\\":\\\"1\\\"}\",\"props\":\"{}\"}");
        Request request = new Request.Builder()
                .url("http://finance-vehicle-disposal.sqaproxy.dasouche-inc.net/auction/auctionList/queryPage.json?current=1&pageSize=20&tabKey=1")
                .post(body)
                .addHeader("JESSIONID", "7BEBC334BD1F5F7636764CDE5D60969C")
                .addHeader("_security_token_inc", "9156464818875353")
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        //获取结果
        System.out.println(response.body().string());


        //取消上拍
        MediaType mediaType2 = MediaType.parse("application/json");
        RequestBody body2 = RequestBody.create(mediaType2, "{\n  \"state\": \"{\\\"queryParam\\\":{},\\\"record\\\":{},\\\"auctionCode\\\":\\\"A20190803125603000241\\\",\\\"cancelReason\\\":\\\"test\\\"}\",\n  \"props\": \"{}\"\n}");
        Request request2 = new Request.Builder()
                .url("http://finance-vehicle-disposal.sqaproxy.dasouche-inc.net/auction/auctionList/cancelAuction.json")
                .post(body2)
                .addHeader("JESSIONID", "7BEBC334BD1F5F7636764CDE5D60969C")
                .addHeader("_security_token_inc", "9156464818875353")
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        //获取取消上拍结果
        Response response2 = client.newCall(request2).execute();
        System.out.println(response2.body().string());

    }
}
