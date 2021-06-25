package id.asad.movie2.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.asad.movie2.data.remote.ResultsItemTvShow
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
class TvShowViewModelTest {

    private lateinit var viewModel : TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer : Observer<List<ResultsItemTvShow?>?>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(contentRepository)
    }

    @Test
    fun getTvShows() {

        val dummyTvShows = FakeDataDummy.generateRemoteDummyTvShow()
        val tvShows = MutableLiveData<List<ResultsItemTvShow?>?>()
        tvShows.value = dummyTvShows

        Mockito.`when`(contentRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntity = viewModel.getTvShows().value
        verify(contentRepository).getAllTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(1, tvShowEntity?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)

    }
}