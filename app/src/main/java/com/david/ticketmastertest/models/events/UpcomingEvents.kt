package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class UpcomingEvents (

	@SerializedName("_total") val _total : Int,
	@SerializedName("ticketmaster") val ticketmaster : Int
)