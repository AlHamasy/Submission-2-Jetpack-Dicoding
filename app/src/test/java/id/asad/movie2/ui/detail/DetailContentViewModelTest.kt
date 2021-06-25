package id.asad.movie2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.repository.ContentRepository
import id.asad.movie2.testing.FakeDataDummy
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailContentViewModelTest {

    private lateinit var viewModel : DetailContentViewModel
    private val dummyMovies = FakeDataDummy.generateRemoteDummyMovies()[0]
    private val movieId = dummyMovies.id
    private val dummyTvShows = FakeDataDummy.generateRemoteDummyTvShow()[0]
    private val tvShowId = dummyTvShows.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var movieObserver : Observer<ResultsItemMovie?>

    @Mock
    private lateinit var tvShowObserver : Observer<ResultsItemTvShow?>

    @Before
    fun setUp() {
        viewModel = DetailContentViewModel(contentRepository)
    }

    @Test
    fun getSelectedMovie() {
        viewModel.setSelectedMovie(movieId ?: 0)

        val movie = MutableLiveData<ResultsItemMovie>()
        movie.value = dummyMovies
        Mockito.`when`(contentRepository.getDetailMovie(movieId)).thenReturn(movie)

        val movieEntity = viewModel.getSelectedMovie().value
        verify(contentRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.overview, movieEntity?.overview)
        assertEquals(dummyMovies.originalLanguage, movieEntity?.originalLanguage)
        assertEquals(dummyMovies.originalTitle, movieEntity?.originalTitle)
        assertEquals(dummyMovies.video, movieEntity?.video)
        assertEquals(dummyMovies.title, movieEntity?.title)
        assertEquals(dummyMovies.genreIds, movieEntity?.genreIds)
        assertEquals(dummyMovies.posterPath, movieEntity?.posterPath)
        assertEquals(dummyMovies.backdropPath, movieEntity?.backdropPath)
        assertEquals(dummyMovies.releaseDate, movieEntity?.releaseDate)
        assertEquals(dummyMovies.popularity, movieEntity?.popularity)
        assertEquals(dummyMovies.voteAverage, movieEntity?.voteAverage)
        assertEquals(dummyMovies.id, movieEntity?.id)
        assertEquals(dummyMovies.adult, movieEntity?.adult)
        assertEquals(dummyMovies.voteCount, movieEntity?.voteCount)

        viewModel.getSelectedMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getSelectedTvShow() {
        viewModel.setSelectedTvShow(tvShowId ?: 0)

        val tvShow = MutableLiveData<ResultsItemTvShow>()
        tvShow.value = dummyTvShows
        Mockito.`when`(contentRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)

        val tvShowEntity = viewModel.getSelectedTvShow().value
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShows.firstAirDate, tvShowEntity?.firstAirDate)
        assertEquals(dummyTvShows.overview, tvShowEntity?.overview)
        assertEquals(dummyTvShows.originalLanguage, tvShowEntity?.originalLanguage)
        assertEquals(dummyTvShows.genreIds, tvShowEntity?.genreIds)
        assertEquals(dummyTvShows.posterPath, tvShowEntity?.posterPath)
        assertEquals(dummyTvShows.originCountry, tvShowEntity?.originCountry)
        assertEquals(dummyTvShows.backdropPath, tvShowEntity?.backdropPath)
        assertEquals(dummyTvShows.originalName, tvShowEntity?.originalName)
        assertEquals(dummyTvShows.popularity, tvShowEntity?.popularity)
        assertEquals(dummyTvShows.voteAverage, tvShowEntity?.voteAverage)
        assertEquals(dummyTvShows.name, tvShowEntity?.name)
        assertEquals(dummyTvShows.id, tvShowEntity?.id)
        assertEquals(dummyTvShows.voteCount, tvShowEntity?.voteCount)


        viewModel.getSelectedTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)

    }
}