package com.gifgroen.base.model.embedded

import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.data.Venue

data class EventLocation(val venues: List<Venue>, val attractions: List<Attraction>) : Result<Nothing>()


