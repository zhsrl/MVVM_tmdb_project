package com.e.tmdblist.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitService{

    const val BASE_URL = "https://api.themoviedb.org/"

    fun getPostApi(): PostApi{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PostApi::class.java)
    }
}

interface PostApi{

    @GET("3/movie/{category}")
    fun getMovies(): Call<List<Movie>>
}
