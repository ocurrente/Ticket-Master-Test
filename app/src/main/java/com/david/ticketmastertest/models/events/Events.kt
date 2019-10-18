package com.david.ticketmastertest.models.events
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "events")
data class Events (

	@PrimaryKey @SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("type") val type : String,
	@SerializedName("test") val test : Boolean,
	@SerializedName("url") val url : String,
	@SerializedName("locale") val locale : String,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("sales") val sales : Sales,
	@SerializedName("dates") val dates : Dates,
	@SerializedName("classifications") val classifications : List<Classifications>,
	@SerializedName("_links") val _links : Links,
	@SerializedName("_embedded") val _embedded : Embedded
)