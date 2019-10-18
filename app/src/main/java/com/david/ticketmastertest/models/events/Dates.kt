package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Dates (

	@SerializedName("start") val start : Start,
	@SerializedName("timezone") val timezone : String,
	@SerializedName("status") val status : Status,
	@SerializedName("spanMultipleDays") val spanMultipleDays : Boolean
)