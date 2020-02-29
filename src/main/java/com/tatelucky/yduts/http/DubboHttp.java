package com.tatelucky.yduts.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author tangsheng
 * @since 2019-08-09
 */
public class DubboHttp {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "vins=%5B%22TESTXC20190109001%22%5D&undefined=");
        Request request = new Request.Builder()
                .url("http://172.17.40.220:20884/com.souche.finance.vehicle.disposal.api.service.auction.AuctionInfoOutService")
                .post(body)
                .addHeader("_dubbo_token", "souche_http_token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("_method_name", "getInfoByVins")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "d680ca64-3b07-42b0-aa74-dafb2b60c9de")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
