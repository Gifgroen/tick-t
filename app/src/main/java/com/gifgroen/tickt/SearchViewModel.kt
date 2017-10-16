package com.gifgroen.tickt

import android.arch.lifecycle.ViewModel
import com.gifgroen.tickt.model.base.Result
import com.gifgroen.tickt.model.embedded.EventSearch
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class SearchViewModel: ViewModel() {
    val repo: Observable<Result<EventSearch>> = EventRepository.discovery().searchEvents("metallica").subscribeOn(Schedulers.computation())
}