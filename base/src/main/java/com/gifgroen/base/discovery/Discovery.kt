package com.gifgroen.base.discovery

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.data.Event
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Discovery {
    // EVENTS
    @GET("discovery/v2/events.json")
    fun eventsByKeyword(@Query("keyword") keyword: String): Observable<Result<EventSearch>>

    @GET("discovery/v2/events.json")
    fun eventsByDateRange(@Query("startDateTime") startDateTime: String, @Query("endDateTime") endDateTime: String): Observable<Result<EventSearch>>

    @GET("discovery/v2/events/{id}")
    fun eventById(@Path("id") id: String): Observable<Event>

    // ATTRACTIONS
    @GET("discovery/v2/attractions.json")
    fun attractionByKeyword(@Query("keyword") keyword: String): Observable<Result<Attraction>>
}
