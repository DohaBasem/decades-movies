package com.task.decadeofmovies.common.network

interface IRetrofitClient {
    fun <APIsInterface> getRetrofitClient(restAPIsInterface: Class<APIsInterface>): APIsInterface
}