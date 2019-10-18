package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName


data class Address (

	@SerializedName("line1") val line1 : String
)