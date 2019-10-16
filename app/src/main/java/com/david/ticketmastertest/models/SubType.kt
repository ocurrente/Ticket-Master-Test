package com.david.ticketmastertest.models

import com.google.gson.annotations.SerializedName


data class SubType (
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String
)