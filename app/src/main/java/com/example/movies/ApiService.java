package com.example.movies;

import com.example.movies.Elements.MovieResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    final String endPoint = "movie?page=1&limit=40&sortField=votes.kp&sortType=-1&rating.kp=7-10";
    final String BASE_URL = "https://api.kinopoisk.dev/";


    @GET(endPoint)
    @Headers({
            "Accept: application/json",
            "X-API-KEY:2TMGQFT-AJZ4R8W-JTR4RQA-XYBEM50"
    })
    Single<MovieResponse> loadMovies();
}
