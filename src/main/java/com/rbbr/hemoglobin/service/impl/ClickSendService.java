package com.rbbr.hemoglobin.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rbbr.hemoglobin.service.SmsService;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.io.IOException;

@Service
public class ClickSendService implements SmsService {

    private final String apiUrl = "https://rest.clicksend.com/v3/";
    private ClickSendApi clickSendApi;

    public ClickSendService(
            @Value("${clicksend.apiUsername}") String apiUsername,
            @Value("${clicksend.apiKey}") String apiKey) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            String credentials = Credentials.basic(apiUsername, apiKey);
            return chain.proceed(chain.request().newBuilder().header("Authorization", credentials).build());
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        clickSendApi = retrofit.create(ClickSendApi.class);
    }

    public void sendSms(String to, String message) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("to", to);
        requestBody.addProperty("body", message);

        JsonObject requestWrapper = new JsonObject();
        JsonArray messages = new JsonArray();
        messages.add(requestBody);
        requestWrapper.add("messages", messages);

        Call<JsonObject> call = clickSendApi.sendSms(requestWrapper);
        try {
            Response<JsonObject> response = call.execute();
            if (!response.isSuccessful()) {
                throw new IOException("Failed to send SMS: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    interface ClickSendApi {
        @POST("sms/send")
        Call<JsonObject> sendSms(@Body JsonObject smsRequest);
    }
}
