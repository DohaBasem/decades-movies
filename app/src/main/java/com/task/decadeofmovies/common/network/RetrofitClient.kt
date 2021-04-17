package com.task.decadeofmovies.common.network

import com.google.gson.GsonBuilder
import com.task.decadeofmovies.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient: IRetrofitClient {
    init {
        buildRetrofit()
    }
    private lateinit var retrofit: Retrofit
    private fun getOkHttpBuilder(): OkHttpClient.Builder{
       return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
    }

    private fun getGsonConverter(): GsonConverterFactory{
        val gson = GsonBuilder().setLenient().create()
        return GsonConverterFactory.create(gson)
    }

    private fun getRetrofitBuilder(): Retrofit.Builder {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(getGsonConverter())
            .client(getOkHttpBuilder().build())
            retrofitBuilder.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        return retrofitBuilder
    }

    fun buildRetrofit(): RetrofitClient {
        retrofit = this.getRetrofitBuilder().build()
        return this
    }

    override fun <APIsInterface> getRetrofitClient(restAPIsInterface: Class<APIsInterface>): APIsInterface {
        return retrofit.create(restAPIsInterface)
    }

    companion object Config{
        const val TIME_OUT = 30L
    }
}