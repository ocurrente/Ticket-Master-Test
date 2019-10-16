package com.david.ticketmastertest.models

import com.google.gson.annotations.SerializedName

data class ExternalLinks (
	@SerializedName("youtube") val youtube : List<Youtube>,
	@SerializedName("twitter") val twitter : List<Twitter>,
	@SerializedName("itunes") val itunes : List<Itunes>,
	@SerializedName("lastfm") val lastfm : List<Lastfm>,
	@SerializedName("facebook") val facebook : List<Facebook>,
	@SerializedName("wiki") val wiki : List<Wiki>,
	@SerializedName("instagram") val instagram : List<Instagram>,
	@SerializedName("musicbrainz") val musicbrainz : List<Musicbrainz>,
	@SerializedName("homepage") val homepage : List<Homepage>
)