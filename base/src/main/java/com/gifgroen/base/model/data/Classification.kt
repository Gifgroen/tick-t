package com.gifgroen.base.model.data

import com.gifgroen.base.model.data.classification.Genre
import com.gifgroen.base.model.data.classification.Segment
import com.gifgroen.base.model.data.classification.Type

data class Classification(
        val primary: Boolean,
        val segment: Segment,
        val genre: Genre,
        val subGenre: Genre,
        val type: Type,
        val subType: Type
)
