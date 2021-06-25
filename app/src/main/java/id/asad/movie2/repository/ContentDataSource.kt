package id.asad.movie2.repository

import androidx.lifecycle.LiveData
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow

interface ContentDataSource {

    fun getAllMovies() : LiveData<List<ResultsItemMovie?>?>
    fun getAllTvShows() : LiveData<List<ResultsItemTvShow?>?>
    fun getDetailMovie(id : Int?) : LiveData<ResultsItemMovie?>
    fun getDetailTvShow(id : Int?) : LiveData<ResultsItemTvShow?>
}