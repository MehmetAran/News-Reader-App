package com.example.appyazlab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {


    @GET("news/list")
    Call<List<News>> newsListCall();

    @GET("news/list/{id}")
    Call<News> findOneNews(@Path("id") int newsId);

    @GET("increaseLike/{id}")
    Call<News> increaseLike(@Path("id") int newsId);

    @GET("decreaseLike/{id}")
    Call<News> decreaseLike(@Path("id") int newsId);

    @GET("increaseDislike/{id}")
    Call<News> increaseDislike(@Path("id") int newsId);

    @GET("decreaseDislike/{id}")
    Call<News> decreaseDislike(@Path("id") int newsId);


}
