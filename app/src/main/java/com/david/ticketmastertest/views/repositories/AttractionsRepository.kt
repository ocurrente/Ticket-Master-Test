package com.david.ticketmastertest.views.repositories

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.models.events.Events
import com.david.ticketmastertest.network.Resource

interface AttractionsRepository {
    fun putKeyword(keyword: String)
    fun getKeyword(): String?
    fun requestAttractions(artist: String): LiveData<Resource<List<Events>>>
    fun requestAttractionDetail(id: String): LiveData<Resource<Events>>
}