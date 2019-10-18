package com.david.ticketmastertest.models.events
import com.google.gson.annotations.SerializedName

data class VenuesEmbedded (
    @SerializedName("venues") val venues : List<Venues>
)