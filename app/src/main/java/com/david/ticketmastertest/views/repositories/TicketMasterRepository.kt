package com.david.ticketmastertest.views.repositories

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.database.OfflineData
import com.david.ticketmastertest.models.events.BaseResponse
import com.david.ticketmastertest.models.events.Events
import com.david.ticketmastertest.network.*
import com.david.ticketmastertest.utils.TicketMasterPreferences
import javax.inject.Inject

class TicketMasterRepository @Inject constructor(
    val appExecutors: AppExecutors,
    val api: TicketMasterApi,
    val cache: OfflineData,
    private val preferences: TicketMasterPreferences
) : AttractionsRepository {

    override fun requestAttractions(
        artist: String
    ): LiveData<Resource<List<Events>>> {
        return object : NetworkBoundResource<List<Events>, BaseResponse>(
            appExecutors
        ) {
            override fun saveCallResult(item: BaseResponse) {
                item._embedded?.let {
                    cache.putAttractions(it.events)
                }
            }

            override fun shouldFetch(data: List<Events>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<List<Events>> {
                return cache.getAttractionsByNameLiveData(artist)
            }

            override fun createCall(): LiveData<ApiResponse<BaseResponse>> {
                return api.getEventsByArtist(artist)
            }
        }.asLiveData()
    }

    override fun putKeyword(keyword: String) {
        preferences.putLatestSearchedKeyword(keyword)
    }

    override fun getKeyword(): String? {
        return preferences.getLatestSearchedKeyword()
    }

    override fun requestAttractionDetail(
        id: String
    ): LiveData<Resource<Events>> {
        return object : NetworkBoundResource<Events, BaseResponse>(
            appExecutors
        ) {
            override fun saveCallResult(item: BaseResponse) {
                item._embedded?.let {
                    cache.putAttractions(it.events)
                }
            }

            override fun shouldFetch(data: Events?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<Events> {
                return cache.getAttractionDetail(id)
            }

            override fun createCall(): LiveData<ApiResponse<BaseResponse>> {
                return api.getEventDetailsById(id)
            }
        }.asLiveData()
    }
}