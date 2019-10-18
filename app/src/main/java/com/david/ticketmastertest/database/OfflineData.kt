package com.david.ticketmastertest.database

import androidx.lifecycle.LiveData
import com.david.ticketmastertest.models.events.Events
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfflineData @Inject constructor(
    private val cacheDatabase: CacheDatabase
) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getAttractionsByNameLiveData(name: String): LiveData<List<Events>> {
        return runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.eventsDao().getEventsLiveData(name)
            }
        }
    }

    fun getAttractionDetail(id: String): LiveData<Events> {
        return runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.eventsDao().getEventsDetailLiveData(id)
            }
        }
    }

    fun putAttractions(attractions: List<Events>) {
        runBlocking {
            withContext(scope.coroutineContext) {
                cacheDatabase.eventsDao().insertAll(attractions)
            }
        }
    }
}