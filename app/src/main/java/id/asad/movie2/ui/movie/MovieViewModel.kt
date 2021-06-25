package id.asad.movie2.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.repository.ContentRepository

class MovieViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getMovies() : LiveData<List<ResultsItemMovie?>?> = contentRepository.getAllMovies()
}