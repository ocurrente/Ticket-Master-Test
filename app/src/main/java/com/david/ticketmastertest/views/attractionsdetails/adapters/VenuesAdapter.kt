package com.david.ticketmastertest.views.attractionsdetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.david.ticketmastertest.R
import com.david.ticketmastertest.models.events.Venues
import java.util.ArrayList

class VenuesAdapter(
    @LayoutRes private val itemLayoutRes: Int = R.layout.venues_item_layout
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val venuesList = ArrayList<Venues>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VenuesHolder(
            LayoutInflater.from(parent.context).inflate(itemLayoutRes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VenuesHolder).bind(venuesList[position])
    }

    override fun getItemCount(): Int {
        return venuesList.size
    }

    fun setVenues(venues: List<Venues>) {
        venuesList.clear()
        venuesList.addAll(venues)
        notifyDataSetChanged()
    }
}