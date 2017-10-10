package com.gifgroen.tickt.model.data

import com.gifgroen.tickt.model.data.place.*
import com.gifgroen.tickt.model.internal.Location

data class Place (
        val area: Area,
        val address: Address,
        val city: City,
        val state: State,
        val country: Country,
        val postalCode: String,
        val location: Location
)
