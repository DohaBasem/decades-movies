package com.task.decadeofmovies.common.di

import androidx.room.Room
import com.task.decadeofmovies.common.db.LocalDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            LocalDB::class.java,
            LocalDB::class.java.simpleName
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { get<LocalDB>().getMoviesDao() }
}