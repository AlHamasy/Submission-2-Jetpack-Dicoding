package id.asad.movie2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.asad.movie2.di.Injection
import id.asad.movie2.repository.ContentRepository
import id.asad.movie2.ui.detail.DetailContentViewModel
import id.asad.movie2.ui.movie.MovieViewModel
import id.asad.movie2.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val contentRepository: ContentRepository) : ViewModelProvider.NewInstanceFactory(){

    companion object{

        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context : Context) : ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(contentRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(contentRepository) as T
            }
            modelClass.isAssignableFrom(DetailContentViewModel::class.java) -> {
                DetailContentViewModel(contentRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}