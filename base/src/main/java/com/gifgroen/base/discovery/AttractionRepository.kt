package com.gifgroen.base.discovery

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.embedded.AttractionSearch
import io.reactivex.Observable

class AttractionRepository(private val networkManager: DiscoveryNetworkManager) {

    fun byKeyword(keyword: String): Observable<List<Attraction>> {
        return networkManager.attractionByKeyword(keyword)
                .map(Result<AttractionSearch>::embedded)
                .flatMap { t: AttractionSearch -> Observable.just(t.attractions) }
    }
}
