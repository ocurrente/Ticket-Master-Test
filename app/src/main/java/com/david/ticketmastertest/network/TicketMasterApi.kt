package com.david.ticketmastertest.network

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.models.events.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterApi {

    @GET("events")
    fun getEventsByArtist(
        @Query("keyword") keyword: String
    ): LiveData<ApiResponse<BaseResponse>>

    @GET("events")
    fun getEventDetailsById(
        @Query("id") keyword: String
    ): LiveData<ApiResponse<BaseResponse>>
}