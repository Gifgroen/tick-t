package com.gifgroen.tickt

import android.arch.lifecycle.ViewModel
import com.gifgroen.base.discovery.DiscoveryNetworkManager
import com.gifgroen.base.discovery.EventRepository
import com.gifgroen.base.model.data.Event
import io.reactivex.Observable
import org.threeten.bp.Instant
import org.threeten.bp.format.DateTimeFormatter

class DiscoveryViewModel : ViewModel() {

    private val mEventRepository: EventRepository

    init {
        val discoveryNetworkManager = DiscoveryNetworkManager()
        mEventRepository = EventRepository(discoveryNetworkManager)
    }

    fun eventsByKeyword(keyword: String): Observable<List<Event>> {
        return mEventRepository.byKeyword(keyword)
    }

    fun eventsByDateRange(start: Instant, end: Instant): Observable<List<Event>> {
        val format = DateTimeFormatter.ISO_INSTANT.toFormat()
        return mEventRepository.byDateRange(format.format(start), format.format(end))
    }
}
