package com.david.ticketmastertest.database

import androidx.room.TypeConverter
import com.david.ticketmastertest.models.events.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CacheConverters {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToLinks(string: String): Links? {
        return gson.fromJson(string, Links::class.java)
    }

    @TypeConverter
    fun linksToString(links: Links): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToUpcomingEvents(string: String): UpcomingEvents? {
        return gson.fromJson(string, UpcomingEvents::class.java)
    }

    @TypeConverter
    fun upcomingEventsToString(links: UpcomingEvents): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToListOfString(string: String): List<String>? {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(string, listType)
    }

    @TypeConverter
    fun listOfStringToString(strings: List<String>?): String? {
        return gson.toJson(strings)
    }

    @TypeConverter
    fun stringToListOfImages(string: String): List<Images?> {
        val listType = object : TypeToken<List<Images>>() {}.type
        return gson.fromJson(string, listType)
    }

    @TypeConverter
    fun listOfImagesToString(images: List<Images>): String {
        return gson.toJson(images)
    }

    @TypeConverter
    fun stringToListOfClassifications(string: String): List<Classifications?> {
        val listType = object : TypeToken<List<Classifications>>() {}.type
        return gson.fromJson(string, listType)
    }

    @TypeConverter
    fun listOfClassificationsToString(classifications: List<Classifications>): String {
        return gson.toJson(classifications)
    }

    @TypeConverter
    fun stringToDates(string: String): Dates? {
        return gson.fromJson(string, Dates::class.java)
    }

    @TypeConverter
    fun datesToString(dates: Dates): String {
        return gson.toJson(dates)
    }

    @TypeConverter
    fun stringToSales(string: String): Sales? {
        return gson.fromJson(string, Sales::class.java)
    }

    @TypeConverter
    fun salesToString(sales: Sales): String {
        return gson.toJson(sales)
    }

    @TypeConverter
    fun stringToEmbedded(string: String): Embedded? {
        return gson.fromJson(string, Embedded::class.java)
    }

    @TypeConverter
    fun embeddedToString(embedded: Embedded): String {
        return gson.toJson(embedded)
    }
}