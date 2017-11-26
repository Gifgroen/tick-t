package com.gifgroen.base.discovery

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Event
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable

class EventRepository(private val networkManager: DiscoveryNetworkManager) {

    fun search(keyword: String) : Observable<List<Event>> {
        return networkManager.search(keyword)
                .map(Result<EventSearch>::embedded)
                .flatMap { eventSearch: EventSearch -> Observable.just(eventSearch.events) }
    }
}
