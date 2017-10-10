package com.gifgroen.tickt.model.internal

data class PriceRange(
        val type: String,
        val currency: String,
        val min: Float,
        val max: Float
)