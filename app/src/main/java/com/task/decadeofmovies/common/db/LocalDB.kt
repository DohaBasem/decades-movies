package com.task.decadeofmovies.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.decadeofmovies.common.db.converters.StringListConverter
import com.task.decadeofmovies.common.db.dao.MoviesDao
import com.task.decadeofmovies.common.db.entities.MovieItemEntity

@Database(
    entities = [
        MovieItemEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class LocalDB : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}