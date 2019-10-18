package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Public (

	@SerializedName("startDateTime") val startDateTime : String,
	@SerializedName("startTBD") val startTBD : Boolean,
	@SerializedName("endDateTime") val endDateTime : String
)