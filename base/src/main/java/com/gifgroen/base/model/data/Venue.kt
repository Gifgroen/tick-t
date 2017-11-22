package com.gifgroen.base.model.data

import com.gifgroen.base.model.base.BaseField
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.place.Address
import com.gifgroen.base.model.data.place.City
import com.gifgroen.base.model.data.place.Country
import com.gifgroen.base.model.data.place.State
import com.gifgroen.base.model.internal.Location

data class Venue(
        val distance: Double,
        val units: String,
        val id: String,
        val locale: String,
        val name: String,
        val description: String,
        val address: Address,
        val city: City,
        val additionalInfo: String,
        val state: State,
        val country: Country,
        val url: String,
        val postalCode: String,
        val location: Location,
        val timezone: String,
        val currency: String,
        val market: List<BaseField>,
        val images: List<Image>,
        val dma: List<BaseField>,
        val social: Social,
        val boxOfficeInfo: BoxOfficeInfo,
        val parkingDetail: String,
        val accessibleSeatingDetail: String,
        val generalInfo: GeneralInfo
        ) : Result<Nothing>()
