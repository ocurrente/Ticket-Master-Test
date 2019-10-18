package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Embedded (

	@SerializedName("events") val events : List<Events>
)