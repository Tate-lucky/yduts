package com.tatelucky.yduts.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author tangsheng
 * @since 2019-08-05
 */
public class MockLoginUtil {

    public static String getLoginToken(String username, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String content = "username=" + username + "&password=" + password;
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("http://sso.dasouche-inc.net/loginAction/login.do")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "f5a0c64a-ff5f67-497d-9618-b48eb5906a48")
                .build();

        Response response = client.newCall(request).execute();
        String html = response.body().string();
        String token = HtmlUtil.getKey(html);
        return token;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getLoginToken("13185070860", "Ts132132"));
    }
}
