package com.gifgroen.base.model.data

import com.gifgroen.base.model.data.place.Address
import com.gifgroen.base.model.data.place.Area
import com.gifgroen.base.model.data.place.City
import com.gifgroen.base.model.data.place.Country
import com.gifgroen.base.model.data.place.State
import com.gifgroen.base.model.internal.Location

data class Place (
        val area: Area,
        val address: Address,
        val city: City,
        val state: State,
        val country: Country,
        val postalCode: String,
        val location: Location
)
