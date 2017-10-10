package com.gifgroen.tickt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EventRepository {

    companion object {
        private val BASE_URL = "https://app.ticketmaster.com/"
        private val service = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().addInterceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url()

                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("apikey", "")
                            .build()

                    val requestBuilder = original.newBuilder().url(url)
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun discovery(): Discovery = service.create(Discovery::class.java)
    }
}