package com.gifgroen.base

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Event
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Discovery {
    @GET("discovery/v2/events.json")
    fun searchEvents(@Query("keyword") keyword: String): Observable<Result<EventSearch>>

    @GET("discovery/v2/events/{id}")
    fun getEvent(@Path("id") id: String): Observable<Event>
}
