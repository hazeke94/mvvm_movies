package com.example.mvvm.data.api

import com.example.mvvm.data.model.MovieDetails
import io.reactivex.Single//single is one type of observable
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {
    // https://api.themoviedb.org/3/movie/popular?api_key=6e63c2317fbe963d76c3bdc2b785f6d1&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=6e63c2317fbe963d76c3bdc2b785f6d1
    // https://api.themoviedb.org/3/


    @GET("movie/{movie_id}")//will use interceptor to pass in api key
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}