package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Markets (

	@SerializedName("name") val name : String,
	@SerializedName("id") val id : Int
)