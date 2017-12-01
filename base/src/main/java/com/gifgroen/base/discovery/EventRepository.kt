package com.gifgroen.base.discovery

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Event
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable

class EventRepository(private val networkManager: DiscoveryNetworkManager) {

    fun byKeyword(keyword: String) : Observable<List<Event>> {
        return convert(networkManager.eventsByKeyword(keyword))
    }

    fun byDateRange(start: String, end: String): Observable<List<Event>> {
        return convert(networkManager.eventsByDateRange(start, end))
    }

    private fun convert(raw: Observable<Result<EventSearch>>) : Observable<List<Event>> {
        return raw.map(Result<EventSearch>::embedded)
                .flatMap { eventSearch: EventSearch -> Observable.just(eventSearch.events) }
    }
}
