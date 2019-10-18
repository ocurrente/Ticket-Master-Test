package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName



data class BaseResponse (

	@SerializedName("_embedded") val _embedded : Embedded?,
	@SerializedName("_links") val _links : Links,
	@SerializedName("page") val page : Page
)