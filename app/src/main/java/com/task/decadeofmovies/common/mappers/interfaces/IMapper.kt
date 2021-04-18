package com.task.decadeofmovies.common.mappers.interfaces

interface IMapper <T, D> {
    fun map(from: T, to: Class<D>): D
}