package com.gifgroen.tickt.model.data

data class Image(
        val eventId: Int,
        val url: String,
        val ratio: String,
        val width: Int,
        val height: Int,
        val fallback: Boolean,
        val attribution: String
)