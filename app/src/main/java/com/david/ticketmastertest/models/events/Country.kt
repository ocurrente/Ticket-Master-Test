package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Country (

	@SerializedName("name") val name : String,
	@SerializedName("countryCode") val countryCode : String
)