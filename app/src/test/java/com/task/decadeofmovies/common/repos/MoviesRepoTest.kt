package com.task.decadeofmovies.common.repos

import com.task.decadeofmovies.baseTest.BaseTest
import com.task.decadeofmovies.common.db.dao.MoviesDao
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.helpers.SharedPreferenceHelper
import com.task.decadeofmovies.common.network.apis.MoviesApi
import com.task.decadeofmovies.common.network.response.MoviesResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.Mockito.*

class MoviesRepoTest : BaseTest() {
    private val moviesDao = Mockito.mock(MoviesDao::class.java)
    private val moviesApi = Mockito.mock(MoviesApi::class.java)
    private val sharedPreferenceHelper = Mockito.mock(SharedPreferenceHelper::class.java)
    private lateinit var moviesRepo: MoviesRepo

    override fun initialize() {
        moviesRepo = MoviesRepo(
            moviesDao = moviesDao,
            moviesApi = moviesApi,
            sharedPreferenceHelper = sharedPreferenceHelper
        )
    }

    @Test
    fun `when loadData_is not first time loading_fetch from db directly`() {
        //prepare
        `when`(
            sharedPreferenceHelper.getBoolean(
                MoviesRepo.MOVIES_FIRST_TIME_LOADING,
                false
            )
        ).thenReturn(false)
        //test
        moviesRepo.fetchAllMovies()
        //verify
        verify(moviesApi, never()).getAllRemoteMovies()
        verify(moviesDao, never()).saveMoviesLocally(listOf())
        verify(moviesDao, times(1)).getAllMovies()
    }


    //TODO handle the test for asynchronous calls
    @Test
    fun `when loadData_is  first time loading_fetch from remote first then db`() {
        //prepare
        val testObserver = TestObserver<MoviesResponse>()
        `when`(
            sharedPreferenceHelper.getBoolean(
                MoviesRepo.MOVIES_FIRST_TIME_LOADING,
                true
            )
        ).thenReturn(true)
        `when`(moviesApi.getAllRemoteMovies()).thenReturn(Single.just(MoviesResponse.createForTesting()))
        `when`(moviesDao.saveMoviesLocally(listOf(MovieItemEntity.createItemForTesting()))).thenReturn(
            Completable.complete())
        //test
        moviesRepo.fetchAllMovies()
        //verify
        verify(moviesApi, times(1)).getAllRemoteMovies()
        verify(moviesDao, times(1)).saveMoviesLocally(listOf(MovieItemEntity.createItemForTesting()))
        verify(moviesDao, times(1)).getAllMovies()
    }

    

    override fun finalize() {
    }

}