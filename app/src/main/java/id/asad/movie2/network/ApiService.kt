package id.asad.movie2.network

import id.asad.movie2.data.remote.MovieResponse
import id.asad.movie2.data.remote.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getDataApiMovie(@Query("api_key") apiKey : String,
                        @Query("language") language : String,
                        @Query("page") page : Int) : Call<MovieResponse>

    @GET("tv/airing_today")
    fun getDataApiTvShow(@Query("api_key") apiKey : String,
                        @Query("language") language : String,
                        @Query("page") page : Int) : Call<TvShowResponse>

}