package com.gifgroen.base.model.internal

data class PriceRange(
        val type: String,
        val currency: String,
        val min: Float,
        val max: Float
)
