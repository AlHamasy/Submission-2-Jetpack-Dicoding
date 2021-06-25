package id.asad.movie2.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import id.asad.movie2.testing.FakeDataDummy
import id.asad.movie2.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.Rule
import org.mockito.Mockito

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val contentRepository = FakeContentRepository(remote)

    private val movieResponse = FakeDataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = FakeDataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id

    @Test
    fun getAllMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
                null
        }.`when`(remote).getAllMovies(any())
        val resultItemMovie = LiveDataTestUtil.getValue(contentRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieResponse)
        assertEquals(movieResponse.size.toLong(), resultItemMovie?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvshowReceived(tvShowResponse)
                null
        }.`when`(remote).getAllTvShows(any())
        val resultItemTvShow = LiveDataTestUtil.getValue(contentRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowResponse)
        assertEquals(tvShowResponse.size.toLong(), resultItemTvShow?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
                null
        }.`when`(remote).getAllMovies(any())
        val resultItemMovie = LiveDataTestUtil.getValue(contentRepository.getDetailMovie(movieId))
        verify(remote).getAllMovies(any())
        assertNotNull(resultItemMovie)
        assertNotNull(resultItemMovie?.title)
        assertEquals(movieResponse[0].title, resultItemMovie?.title)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvshowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())
        val resultItemTvShow = LiveDataTestUtil.getValue(contentRepository.getDetailTvShow(tvShowId))
        verify(remote).getAllTvShows(any())
        assertNotNull(resultItemTvShow)
        assertNotNull(resultItemTvShow?.name)
        assertEquals(tvShowResponse[0].name, resultItemTvShow?.name)
    }

}