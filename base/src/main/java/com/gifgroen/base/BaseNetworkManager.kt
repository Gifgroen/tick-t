package com.gifgroen.base

import com.gifgroen.base.discovery.Discovery
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseNetworkManager {

    private val API_KEY by lazy { "" }

    private val BASE_URL by lazy { "https://app.ticketmaster.com/" }

    private val CALL_ADAPTER_FACTORY by lazy { RxJava2CallAdapterFactory.create() }

    private val GSON_CONVERTER_FACTORY by lazy { GsonConverterFactory.create() }

    private val service = Retrofit.Builder()
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
            .build()

    fun create(serviceType: Class<Discovery>): Discovery {
        return service.create(serviceType)
    }

}
