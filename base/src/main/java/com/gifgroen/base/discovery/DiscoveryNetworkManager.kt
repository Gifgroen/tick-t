package com.gifgroen.base.discovery

import com.gifgroen.base.BaseNetworkManager
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.embedded.AttractionSearch
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DiscoveryNetworkManager : BaseNetworkManager() {
    private val discovery: Discovery = create(Discovery::class.java)

    fun eventsByKeyword(keyword: String): Observable<Result<EventSearch>> {
        return discovery.eventsByKeyword(keyword)
                .subscribeOn(Schedulers.io())
    }

    fun eventsByDateRange(start: String, end: String): Observable<Result<EventSearch>> {
        return discovery.eventsByDateRange(start, end)
                .subscribeOn(Schedulers.io())
    }

    fun attractionByKeyword(keyword: String): Observable<Result<AttractionSearch>> {
        return discovery.attractionByKeyword(keyword)
                .subscribeOn(Schedulers.io())
    }
}
