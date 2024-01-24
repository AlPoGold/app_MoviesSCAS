package com.example.movies;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.text.DateFormat;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    public static final String endPoint = "movie?token=2TMGQFT-AJZ4R8W-JTR4RQA-XYBEM50&page=1&limit=40&sortField=votes.kp&sortType=-1&rating.kp=7-10";
    public static final String BASE_URL = "https://api.kinopoisk.dev/";

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    public static  final  ApiService apiService = retrofit.create(ApiService.class);
}
