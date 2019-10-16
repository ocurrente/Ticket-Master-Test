package com.david.ticketmastertest.models

import com.google.gson.annotations.SerializedName

data class Embedded (
	@SerializedName("attractions") val attractions : List<Attractions>
)