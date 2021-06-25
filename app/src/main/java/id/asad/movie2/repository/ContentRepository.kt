package id.asad.movie2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow

class ContentRepository private constructor(private val remoteDataSource : RemoteDataSource) : ContentDataSource{

    companion object{
        @Volatile
        private var instance : ContentRepository? = null
        fun getInstance(remoteData : RemoteDataSource) : ContentRepository =
            instance ?: synchronized(this){
                instance ?: ContentRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<ResultsItemMovie?>?> {

        val movieResults = MutableLiveData<List<ResultsItemMovie?>?>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(moviesResponses: List<ResultsItemMovie?>?) {
                movieResults.postValue(moviesResponses)
            }
            override fun onFailure(localizedMessage: String) {
            }
        })
        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<ResultsItemTvShow?>?> {

        val tvShowResults = MutableLiveData<List<ResultsItemTvShow?>?>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback{
            override fun onAllTvshowReceived(tvShowsResponse: List<ResultsItemTvShow?>?) {
                tvShowResults.postValue(tvShowsResponse)
            }
            override fun onFailure(localizedMessage: String) {
            }
        })
        return tvShowResults
    }

    override fun getDetailMovie(id: Int?): LiveData<ResultsItemMovie?> {

        val movieResult = MutableLiveData<ResultsItemMovie?>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(moviesResponses: List<ResultsItemMovie?>?) {
                lateinit var movie : ResultsItemMovie
                if (moviesResponses != null) {
                    for (response in moviesResponses){
                        if (response?.id == id){
                            movie = ResultsItemMovie(response?.overview, response?.originalLanguage, response?.originalTitle,
                                                    response?.video, response?.title, response?.genreIds, response?.posterPath,
                                                    response?.backdropPath, response?.releaseDate, response?.popularity,
                                                    response?.voteAverage, response?.id, response?.adult, response?.voteCount)
                        }
                    }
                    movieResult.postValue(movie)
                }
            }
            override fun onFailure(localizedMessage: String) {
            }
        })
        return movieResult
    }

    override fun getDetailTvShow(id: Int?): LiveData<ResultsItemTvShow?> {

        val tvShowResult = MutableLiveData<ResultsItemTvShow?>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback{
            override fun onAllTvshowReceived(tvShowsResponse: List<ResultsItemTvShow?>?) {
                lateinit var tvShow: ResultsItemTvShow
                if (tvShowsResponse != null){
                    for (response in tvShowsResponse){
                        if (response?.id == id){
                            tvShow = ResultsItemTvShow(response?.firstAirDate, response?.overview,response?.originalLanguage,
                                                        response?.genreIds, response?.posterPath, response?.originCountry,
                                                        response?.backdropPath, response?.originalName, response?.popularity,
                                                        response?.voteAverage, response?.name, response?.id, response?.voteCount)
                        }
                    }
                    tvShowResult.postValue(tvShow)
                }
            }
            override fun onFailure(localizedMessage: String) {
            }
        })
        return tvShowResult
    }

}