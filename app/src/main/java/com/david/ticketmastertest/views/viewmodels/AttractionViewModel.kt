package com.david.ticketmastertest.views.viewmodels

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.david.ticketmastertest.models.Attractions
import com.david.ticketmastertest.network.Resource
import com.david.ticketmastertest.network.Status.*
import com.david.ticketmastertest.views.repositories.AttractionsRepository
import javax.inject.Inject
import kotlin.reflect.KClass

class AttractionViewModel @Inject constructor(
    private val repository: AttractionsRepository
) : ViewModel() {

    val currentDetailsId = MutableLiveData<String>()
    val currentFragment = MutableLiveData<KClass<out Fragment>>()

    val isLoading = MutableLiveData<Boolean>()
    private val attractionsRequest = MutableLiveData<String>()
    private val attractionDetailRequest = MutableLiveData<String>()

    private var searchResult: LiveData<Resource<List<Attractions>>> =
        Transformations.switchMap(attractionsRequest) { name ->
            repository.requestAttractions(name)
        }

    val artistAttractions: LiveData<List<Attractions>> = Transformations.map(searchResult) {
        processAttractions(it)
    }

    private var detailsSearchResult: LiveData<Resource<Attractions>> =
        Transformations.switchMap(attractionDetailRequest) { id ->
            repository.requestAttractionDetail(id)
        }

    val attractionDetails: LiveData<Attractions?> = Transformations.map(detailsSearchResult) {
        processAttractionDetails(it)
    }

    internal fun getAttractions(name: String) {
        repository.putKeyword(name)
        attractionsRequest.value = name
    }

    internal fun getAttractionDetails() {
        attractionDetailRequest.value = currentDetailsId.value
    }

    private fun processAttractions(
        result: Resource<List<Attractions>>
    ): List<Attractions> {
        when (result.status) {
            SUCCESS -> {
                return processAttractionsResult(result)
            }
            ERROR -> {
                val message = result.message
                Log.e(message, "Error while getting artist data.")
                return processAttractionsResult(result)
            }
            LOADING -> {
                isLoading.value = true
            }
        }
        return emptyList()
    }

    private fun processAttractionsResult(
        result: Resource<List<Attractions>>
    ): List<Attractions> {
        isLoading.value = false
        return result.data ?: emptyList()
    }

    private fun processAttractionDetails(
        result: Resource<Attractions>
    ): Attractions? {
        when (result.status) {
            SUCCESS -> {
                return processAttractionDetailsResult(result)
            }
            ERROR -> {
                val message = result.message
                Log.e(message, "Error while getting attraction details.")
                return processAttractionDetailsResult(result)
            }
            LOADING -> {
                isLoading.value = true
            }
        }
        return null
    }

    private fun processAttractionDetailsResult(
        result: Resource<Attractions>
    ): Attractions? {
        isLoading.value = false
        return result.data
    }

    internal fun getKeyword(): String? {
        return repository.getKeyword()
    }
}