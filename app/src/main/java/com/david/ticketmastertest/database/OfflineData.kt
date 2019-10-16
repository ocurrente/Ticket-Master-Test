package com.david.ticketmastertest.database

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.models.Attractions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfflineData @Inject constructor(
    private val cacheDatabase: CacheDatabase
) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getAttractionsByNameLiveData(name: String): LiveData<List<Attractions>> {
        return runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.attractionsDao().getAttractionsLiveData(name)
            }
        }
    }

    fun getAttractionDetail(id: String): LiveData<Attractions> {
        return runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.attractionsDao().getAttractionDetailLiveData(id)
            }
        }
    }

    fun putAttractions(attractions: List<Attractions>) {
        runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.attractionsDao().insertAll(attractions)
            }
        }
    }
}