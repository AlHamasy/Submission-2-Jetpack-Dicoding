package id.asad.movie2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.repository.ContentRepository

class DetailContentViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    private var id : Int = 0

    fun setSelectedMovie(id : Int){
        this.id = id
    }
    fun setSelectedTvShow(id : Int){
        this.id = id
    }

    fun getSelectedMovie() : LiveData<ResultsItemMovie?> = contentRepository.getDetailMovie(id)

    fun getSelectedTvShow() : LiveData<ResultsItemTvShow?> = contentRepository.getDetailTvShow(id)

}