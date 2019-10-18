package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Location (

	@SerializedName("longitude") val longitude : Double,
	@SerializedName("latitude") val latitude : Double
)