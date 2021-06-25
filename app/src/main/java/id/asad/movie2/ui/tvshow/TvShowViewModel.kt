package id.asad.movie2.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.repository.ContentRepository

class TvShowViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getTvShows() : LiveData<List<ResultsItemTvShow?>?> = contentRepository.getAllTvShows()
}