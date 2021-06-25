package id.asad.movie2.repository

import id.asad.movie2.BuildConfig
import id.asad.movie2.data.remote.MovieResponse
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.data.remote.TvShowResponse
import id.asad.movie2.network.ApiClient
import id.asad.movie2.testing.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply {
                    instance = this
                }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback){
        EspressoIdlingResource.increment()
        ApiClient.getService().getDataApiMovie(BuildConfig.API_KEY, "en-US", 1).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.onFailure(t.localizedMessage)
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callback.onAllMoviesReceived(response.body()?.results)
            }
        })
        EspressoIdlingResource.decrement()
    }

    fun getAllTvShows(callback: LoadTvShowsCallback){
        EspressoIdlingResource.increment()
        ApiClient.getService().getDataApiTvShow(BuildConfig.API_KEY, "en-US", 1).enqueue(object : Callback<TvShowResponse>{
            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                callback.onFailure(t.localizedMessage)
            }
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                callback.onAllTvshowReceived(response.body()?.results)
            }
        })
        EspressoIdlingResource.decrement()
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: List<ResultsItemMovie?>?)
        fun onFailure(localizedMessage : String)
    }

    interface LoadTvShowsCallback {
        fun onAllTvshowReceived(tvShowsResponse: List<ResultsItemTvShow?>?)
        fun onFailure(localizedMessage : String)
    }

}