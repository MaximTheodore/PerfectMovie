package com.example.perfectmovie;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceBuilder {
    private static String API_KEY = "653326fa-67fd-47cc-8427-9a92bb57372a";
    private static String URL = "https://kinopoiskapiunofficial.tech/";
    private static Retrofit retrofit = null;
    static Retrofit buildRequest(){

        Interceptor interceptor = chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("X-API-KEY", API_KEY)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
