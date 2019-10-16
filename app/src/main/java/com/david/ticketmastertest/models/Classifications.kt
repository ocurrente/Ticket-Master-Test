package com.david.ticketmastertest.models

import com.google.gson.annotations.SerializedName

data class Classifications (
	@SerializedName("primary") val primary : Boolean,
	@SerializedName("segment") val segment : Segment,
	@SerializedName("genre") val genre : Genre,
	@SerializedName("subGenre") val subGenre : SubGenre,
	@SerializedName("type") val type : Type,
	@SerializedName("subType") val subType : SubType,
	@SerializedName("family") val family : Boolean
)