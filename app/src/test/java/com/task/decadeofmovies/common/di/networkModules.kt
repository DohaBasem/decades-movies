package com.task.decadeofmovies.common.di

import com.task.decadeofmovies.common.network.IRetrofitClient
import com.task.decadeofmovies.common.network.RetrofitClient
import com.task.decadeofmovies.common.network.apis.MoviesApi
import com.task.decadeofmovies.common.network.apis.PhotosApi
import org.koin.dsl.module

val networkModules = module {
    single { RetrofitClient() as IRetrofitClient}
    factory { get<IRetrofitClient>().getRetrofitClient(MoviesApi::class.java) }
    factory { get<IRetrofitClient>().getRetrofitClient(PhotosApi::class.java) }
}