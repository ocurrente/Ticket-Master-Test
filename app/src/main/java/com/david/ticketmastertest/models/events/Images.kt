package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Images (

	@SerializedName("ratio") val ratio : String,
	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("fallback") val fallback : Boolean
)