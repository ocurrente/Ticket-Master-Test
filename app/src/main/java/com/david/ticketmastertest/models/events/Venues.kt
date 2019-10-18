package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName




data class Venues (

	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("id") val id : String,
	@SerializedName("test") val test : Boolean,
	@SerializedName("url") val url : String,
	@SerializedName("locale") val locale : String,
	@SerializedName("postalCode") val postalCode : String,
	@SerializedName("timezone") val timezone : String,
	@SerializedName("city") val city : City,
	@SerializedName("country") val country : Country,
	@SerializedName("address") val address : Address,
	@SerializedName("location") val location : Location,
	@SerializedName("markets") val markets : List<Markets>,
	@SerializedName("dmas") val dmas : List<Dmas>,
	@SerializedName("upcomingEvents") val upcomingEvents : UpcomingEvents,
	@SerializedName("_links") val _links : Links
)