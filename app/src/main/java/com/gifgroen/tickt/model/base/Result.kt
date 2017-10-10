package com.gifgroen.tickt.model.base

import com.gifgroen.tickt.model.meta.ExternalLinks
import com.gifgroen.tickt.model.meta.LinkMeta
import com.gifgroen.tickt.model.meta.PageMeta
import com.google.gson.annotations.SerializedName

open class Result<T> (
        @SerializedName("_embedded") var embedded: T? = null,
        @SerializedName("_links") var links: LinkMeta? = null,
        val page: PageMeta? = null,
        val externalLinks: ExternalLinks? = null,
        val test: Boolean? = null
)
