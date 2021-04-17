package com.task.decadeofmovies.common.mappers

interface IMapper <T, D> {
    fun map(from: T, to: Class<D>): D
}