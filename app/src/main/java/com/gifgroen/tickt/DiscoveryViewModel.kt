package com.gifgroen.tickt

import android.arch.lifecycle.ViewModel
import com.gifgroen.base.discovery.AttractionRepository
import com.gifgroen.base.discovery.DiscoveryNetworkManager
import com.gifgroen.base.discovery.EventRepository
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.data.Event
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.threeten.bp.Instant
import org.threeten.bp.format.DateTimeFormatter

class DiscoveryViewModel : ViewModel() {

    private val mEventRepository: EventRepository

    private val mAttractionRepository: AttractionRepository

    init {
        val discoveryNetworkManager = DiscoveryNetworkManager()
        mEventRepository = EventRepository(discoveryNetworkManager)
        mAttractionRepository = AttractionRepository(discoveryNetworkManager)
    }

    fun eventsByKeyword(keyword: String): Observable<List<Event>> {
        return mEventRepository.byKeyword(keyword)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun eventsByDateRange(start: Instant, end: Instant): Observable<List<Event>> {
        val format = DateTimeFormatter.ISO_INSTANT.toFormat()
        return mEventRepository.byDateRange(format.format(start), format.format(end))
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun attractionByKeyword(keyword: String): Observable<List<Attraction>> {
        return mAttractionRepository.byKeyword(keyword)
                .observeOn(AndroidSchedulers.mainThread())
    }
}
