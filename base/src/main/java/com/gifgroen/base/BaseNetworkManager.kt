package com.gifgroen.base

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = ""

const val BASE_URL = "https://app.ticketmaster.com/"

open class BaseNetworkManager {

    private val CALL_ADAPTER_FACTORY by lazy { RxJava2CallAdapterFactory.create() }

    private val GSON_CONVERTER_FACTORY by lazy { GsonConverterFactory.create() }

    private val service by lazy { Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor {
                val original = it.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", API_KEY)
                        .build()
                val request = original.newBuilder().url(url).build()
                it.proceed(request)
            }.build())
            .addCallAdapterFactory(CALL_ADAPTER_FACTORY)
            .addConverterFactory(GSON_CONVERTER_FACTORY)
            .build() }

    fun <T> create(serviceType: Class<T>): T {
        return service.create(serviceType)
    }

}
