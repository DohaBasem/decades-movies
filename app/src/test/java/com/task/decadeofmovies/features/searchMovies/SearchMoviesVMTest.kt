package com.task.decadeofmovies.features.searchMovies

import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.decadeofmovies.baseTest.BaseTest
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.helpers.LoggingHelper
import com.task.decadeofmovies.common.helpers.SchedulerHelper
import com.task.decadeofmovies.common.repos.MoviesRepo
import com.task.decadeofmovies.common.repos.interfaces.IMoviesRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class SearchMoviesVMTest: BaseTest() {

    private val loggingHelper:ILoggingHelper = Mockito.mock(LoggingHelper::class.java)
    private val schedulerHelper:ISchedulerHelper = Mockito.mock(SchedulerHelper::class.java)
    private val moviesRepo: IMoviesRepo = Mockito.mock(MoviesRepo::class.java)

    private lateinit var moviesVM: SearchMoviesVM

    override fun initialize() {
        moviesVM = SearchMoviesVM(loggingHelper,schedulerHelper,moviesRepo)
    }

    @Test
    fun `when getAllMovies_is successfull but with empty movies list_viewstate is LoadedWithNoPayLoad`(){
        //prepare
        `when`(moviesRepo.fetchAllMovies()).thenReturn(Single.just(emptyList()))
        `when`(schedulerHelper.getSubscriptionScheduler()).thenReturn(Schedulers.trampoline())
        `when`(schedulerHelper.getObservationScheduler()).thenReturn(Schedulers.trampoline())
        //test
        moviesVM.getAllMovies()
        //verify
        assertEquals(moviesVM.moviesViewState.value,MoviesViewState.LoadedWithEmptyPayLoad)
    }

    @Test
    fun `when getAllMovies_is successfull and with movies list_viewstate is LoadedWithPayLoad`(){
        //prepare
        `when`(moviesRepo.fetchAllMovies()).thenReturn(Single.just(listOf(MovieItemEntity.createItemForTesting())))
        `when`(schedulerHelper.getSubscriptionScheduler()).thenReturn(Schedulers.trampoline())
        `when`(schedulerHelper.getObservationScheduler()).thenReturn(Schedulers.trampoline())
        //test
        moviesVM.getAllMovies()
        //verify
        assertTrue(moviesVM.moviesViewState.value is MoviesViewState.LoadedWithPayLoad)
    }

    @Test
    fun `when getAllMovies_fails_viewstate is GenericError`(){
        //prepare
        `when`(moviesRepo.fetchAllMovies()).thenReturn(Single.error(Throwable()))
        `when`(schedulerHelper.getSubscriptionScheduler()).thenReturn(Schedulers.trampoline())
        `when`(schedulerHelper.getObservationScheduler()).thenReturn(Schedulers.trampoline())
        //test
        moviesVM.getAllMovies()
        //verify
        assertTrue(moviesVM.moviesViewState.value is MoviesViewState.GenericError)
    }

    override fun finalize() {
    }

}