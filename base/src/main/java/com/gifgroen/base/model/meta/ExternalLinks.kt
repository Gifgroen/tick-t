package com.gifgroen.base.model.meta

data class ExternalLinks (
        val youtube: List<LinkItem>,
        val twitter: List<LinkItem>,
        val itunes: List<LinkItem>,
        val lastfm: List<LinkItem>,
        val facebook: List<LinkItem>,
        val wiki: List<LinkItem>,
        val instagram: List<LinkItem>,
        val musicbrainz: List<LinkItem>,
        val homepage: List<LinkItem>
)
