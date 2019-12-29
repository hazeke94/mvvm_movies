package com.example.mvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.mvvm.data.api.TheMovieDBInterface
import com.example.mvvm.data.model.MovieDetails
import com.example.mvvm.data.repository.MovieDetailsDataSource
import com.example.mvvm.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface){
    lateinit var movieDetailsNetworkDataSource: MovieDetailsDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {
        movieDetailsNetworkDataSource = MovieDetailsDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }
    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}