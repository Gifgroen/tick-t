package com.gifgroen.base

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EventRepository {

    companion object {
        const val BASE_URL = "https://app.ticketmaster.com/"
        const val API_KEY = ""

        private val service = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().addInterceptor {
                    val original = it.request()
                    val originalHttpUrl = original.url()

                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("apikey", API_KEY)
                            .build()

                    val requestBuilder = original.newBuilder().url(url)
                    val request = requestBuilder.build()
                    it.proceed(request)
                }.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun discovery(): Discovery = service.create(Discovery::class.java)
    }
}
