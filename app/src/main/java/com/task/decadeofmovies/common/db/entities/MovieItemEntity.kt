package com.task.decadeofmovies.common.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val year: String,
    val rating: Int,
    val cast: List<String>?,
    val generes: List<String>?
)