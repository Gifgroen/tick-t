package com.gifgroen.base.discovery

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable

class EventRepository(private val networkManager: DiscoveryNetworkManager) {

    fun search(keyword: String) : Observable<Result<EventSearch>> {
        return networkManager.search(keyword)
    }
}
