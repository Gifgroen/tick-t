package com.gifgroen.tickt

import android.arch.lifecycle.ViewModel
import com.gifgroen.base.discovery.DiscoveryNetworkManager
import com.gifgroen.base.discovery.EventRepository
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.embedded.EventSearch
import io.reactivex.Observable

class DiscoveryViewModel : ViewModel() {

    private val mRepository: EventRepository

    init {
        val discoveryNetworkManager = DiscoveryNetworkManager()
        mRepository = EventRepository(discoveryNetworkManager)
    }

    fun search(keyword: String): Observable<Result<EventSearch>> {
        return mRepository.search(keyword)
    }
}
