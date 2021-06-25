package id.asad.movie2.di

import android.content.Context
import id.asad.movie2.repository.ContentRepository
import id.asad.movie2.repository.RemoteDataSource

object Injection {

    fun provideRepository(context : Context) : ContentRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return ContentRepository.getInstance(remoteDataSource)
    }

}