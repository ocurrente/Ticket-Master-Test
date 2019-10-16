package com.david.ticketmastertest.utils

import android.content.SharedPreferences

class TicketMasterPreferences(private val sharedPreferences: SharedPreferences) {

    fun putLatestSearchedKeyword(keyword: String) {
        sharedPreferences.edit().putString(SEARCHED_KEYWORD, keyword).apply()
    }

    fun getLatestSearchedKeyword(): String? {
        return sharedPreferences.getString(SEARCHED_KEYWORD, null)
    }

    companion object {
        const val SEARCHED_KEYWORD = "searched_keyword"
    }
}