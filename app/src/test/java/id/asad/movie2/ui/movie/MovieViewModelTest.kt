package id.asad.movie2.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.repository.ContentRepository
import id.asad.movie2.testing.FakeDataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer : Observer<List<ResultsItemMovie?>?>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(contentRepository)
    }

    @Test
    fun getMovies() {

        val dummyMovies = FakeDataDummy.generateRemoteDummyMovies()
        val movies = MutableLiveData<List<ResultsItemMovie?>?>()
        movies.value = dummyMovies

        Mockito.`when`(contentRepository.getAllMovies()).thenReturn(movies)
        val movieEntity = viewModel.getMovies().value
        verify(contentRepository).getAllMovies()
        assertNotNull(movieEntity)
        assertEquals(1, movieEntity?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}

