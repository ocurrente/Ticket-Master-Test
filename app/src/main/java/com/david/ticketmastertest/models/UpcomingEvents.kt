package com.david.ticketmastertest.models

import com.google.gson.annotations.SerializedName

data class UpcomingEvents (
	@SerializedName("_total") val _total : Int
)