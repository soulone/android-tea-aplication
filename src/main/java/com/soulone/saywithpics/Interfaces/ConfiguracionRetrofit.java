package com.soulone.saywithpics.Interfaces;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfiguracionRetrofit {
    public static JsonPostsApi jsonApiRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8085")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPostsApi jsonPostsApi=retrofit.create(JsonPostsApi.class);

        return jsonPostsApi;
    }
}
