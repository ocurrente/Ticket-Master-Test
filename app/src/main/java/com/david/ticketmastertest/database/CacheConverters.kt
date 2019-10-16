package com.david.ticketmastertest.database

import androidx.room.TypeConverter
import com.david.ticketmastertest.models.*
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
    fun stringToExternalLinks(externalLinks: String): ExternalLinks? {
        return gson.fromJson(externalLinks, ExternalLinks::class.java)
    }

    @TypeConverter
    fun externalLinksToString(links: ExternalLinks?): String? {
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

    /*@TypeConverter
    fun stringToYoutube(string: String): Youtube? {
        return gson.fromJson(string, Youtube::class.java)
    }

    @TypeConverter
    fun youtubeToString(links: Youtube): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToTwitter(string: String): Twitter? {
        return gson.fromJson(string, Twitter::class.java)
    }

    @TypeConverter
    fun twitterToString(links: Twitter): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToItunes(string: String): Itunes? {
        return gson.fromJson(string, Itunes::class.java)
    }

    @TypeConverter
    fun itunesToString(links: Itunes): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToLastfm(string: String): Lastfm? {
        return gson.fromJson(string, Lastfm::class.java)
    }

    @TypeConverter
    fun lastfmToString(links: Lastfm): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToFacebook(string: String): Facebook? {
        return gson.fromJson(string, Facebook::class.java)
    }

    @TypeConverter
    fun facebookToString(links: Facebook): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToWiki(string: String): Wiki? {
        return gson.fromJson(string, Wiki::class.java)
    }

    @TypeConverter
    fun wikiToString(links: Wiki): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToInstagram(string: String): Instagram? {
        return gson.fromJson(string, Instagram::class.java)
    }

    @TypeConverter
    fun instagramToString(links: Instagram): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToMusicbrainz(string: String): Musicbrainz? {
        return gson.fromJson(string, Musicbrainz::class.java)
    }

    @TypeConverter
    fun musicbrainzToString(links: Musicbrainz): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToHomepage(string: String): Homepage? {
        return gson.fromJson(string, Homepage::class.java)
    }

    @TypeConverter
    fun homepageToString(links: Homepage): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToImages(string: String): Images? {
        return gson.fromJson(string, Images::class.java)
    }

    @TypeConverter
    fun imagesToString(links: Images): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToClassifications(string: String): Classifications? {
        return gson.fromJson(string, Classifications::class.java)
    }

    @TypeConverter
    fun classificationsToString(links: Classifications): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToSegment(string: String): Segment? {
        return gson.fromJson(string, Segment::class.java)
    }

    @TypeConverter
    fun segmentToString(links: Segment): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToGenre(string: String): Genre? {
        return gson.fromJson(string, Genre::class.java)
    }

    @TypeConverter
    fun genreToString(links: Genre): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToSubGenre(string: String): SubGenre? {
        return gson.fromJson(string, SubGenre::class.java)
    }

    @TypeConverter
    fun subGenreToString(links: SubGenre): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToType(string: String): Type? {
        return gson.fromJson(string, Type::class.java)
    }

    @TypeConverter
    fun typeToString(links: Type): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToSubType(string: String): SubType? {
        return gson.fromJson(string, SubType::class.java)
    }

    @TypeConverter
    fun subTypeToString(links: SubType): String {
        return gson.toJson(links)
    }

    @TypeConverter
    fun stringToSelf(string: String): Self? {
        return gson.fromJson(string, Self::class.java)
    }

    @TypeConverter
    fun selfToString(links: Self): String {
        return gson.toJson(links)
    }*/
}