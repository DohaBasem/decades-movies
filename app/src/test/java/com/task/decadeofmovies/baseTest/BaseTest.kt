package com.task.decadeofmovies.baseTest

import android.content.Context
import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.task.decadeofmovies.common.di.getKoinTestModules
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


abstract class BaseTest : KoinTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        val sharedPrefs = Mockito.mock(
            SharedPreferences::class.java)
        Mockito.`when`(
            mockContext.getSharedPreferences(
                anyString(),
                anyInt()
            )
        ).thenReturn(sharedPrefs)

        startKoin {
            androidContext(mockContext)
            modules(getKoinTestModules())
        }
        initialize()
    }

    abstract fun initialize()

    abstract fun finalize()

    @After
    fun end() {
        finalize()
        stopKoin()
    }
}