package com.david.ticketmastertest.views.repositories

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.database.OfflineData
import com.david.ticketmastertest.models.Attractions
import com.david.ticketmastertest.models.BaseResponse
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
    ): LiveData<Resource<List<Attractions>>> {
        return object : NetworkBoundResource<List<Attractions>, BaseResponse>(
            appExecutors
        ) {
            override fun saveCallResult(item: BaseResponse) {
                item._embedded?.let {
                    cache.putAttractions(it.attractions)
                }
            }

            override fun shouldFetch(data: List<Attractions>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<List<Attractions>> {
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
    ): LiveData<Resource<Attractions>> {
        return object : NetworkBoundResource<Attractions, BaseResponse>(
            appExecutors
        ) {
            override fun saveCallResult(item: BaseResponse) {
                item._embedded?.let {
                    cache.putAttractions(it.attractions)
                }
            }

            override fun shouldFetch(data: Attractions?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<Attractions> {
                return cache.getAttractionDetail(id)
            }

            override fun createCall(): LiveData<ApiResponse<BaseResponse>> {
                return api.getEventDetailsById(id)
            }
        }.asLiveData()
    }
}