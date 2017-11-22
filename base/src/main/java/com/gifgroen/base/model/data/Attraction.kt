package com.gifgroen.base.model.data

data class Attraction(
        val type: String,
        val id: String,
        val locale: String,
        val name: String,
        val description: String,
        val additionalInfo: String,
        val url: String,
        val images: List<Image>,
        val classification: List<Classification>
)
