package com.gifgroen.tickt.model.data

import com.gifgroen.tickt.model.base.Result
import com.gifgroen.tickt.model.embedded.EventLocation
import com.gifgroen.tickt.model.internal.Location
import com.gifgroen.tickt.model.internal.PriceRange
import com.gifgroen.tickt.model.internal.Promoter
import com.gifgroen.tickt.model.internal.SeatMap

data class Event(
        val type: String,
        val distance: Double,
        val units: String,
        val location: Location,
        val id: String,
        val locale: String,
        val name: String,
        val description: String,
        val additionalInfo: String,
        val url: String,
        val images: List<Image>,
        // TODO: Dates dates
        // TODO: Sales sales
        val info: String,
        val pleaseNote: String,
        val priceRanges: PriceRange,
        val promoter: Promoter,
        val seatMap: SeatMap,
        val classification: List<Classification>,
        val place: Place
        )
    : Result<EventLocation>()
