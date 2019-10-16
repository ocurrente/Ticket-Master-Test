package com.david.ticketmastertest.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "attractions")
data class Attractions (
	@PrimaryKey @SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("test") val test : Boolean,
	@SerializedName("url") val url : String?,
	@SerializedName("locale") val locale : String,
	@SerializedName("externalLinks") val externalLinks : ExternalLinks?,
	@SerializedName("aliases") val aliases : List<String>?,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("classifications") val classifications : List<Classifications>,
	@SerializedName("upcomingEvents") val upcomingEvents : UpcomingEvents,
	@SerializedName("_links") val _links : Links
)