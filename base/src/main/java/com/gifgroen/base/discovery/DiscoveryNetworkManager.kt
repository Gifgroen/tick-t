package com.gifgroen.base.discovery

import com.gifgroen.base.BaseNetworkManager
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DiscoveryNetworkManager : BaseNetworkManager() {
    private val discovery: Discovery = create(Discovery::class.java)

    fun search(keyword: String): Observable<Result<EventSearch>> {
        return discovery.searchEvents(keyword)
                .subscribeOn(Schedulers.io())
    }
}
