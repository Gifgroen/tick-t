package com.gifgroen.tickt.model.embedded

import com.gifgroen.tickt.model.base.Result
import com.gifgroen.tickt.model.data.Attraction
import com.gifgroen.tickt.model.data.Venue

data class EventLocation(val venues: List<Venue>, val attractions: List<Attraction>) : Result<Nothing>()


