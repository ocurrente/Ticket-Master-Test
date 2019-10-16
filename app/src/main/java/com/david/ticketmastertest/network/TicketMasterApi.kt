package com.david.ticketmastertest.network

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.models.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterApi {

    @GET("attractions")
    fun getEventsByArtist(
        @Query("keyword") keyword: String
    ): LiveData<ApiResponse<BaseResponse>>

    @GET("attractions")
    fun getEventDetailsById(
        @Query("id") keyword: String
    ): LiveData<ApiResponse<BaseResponse>>
}