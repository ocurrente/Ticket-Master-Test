package com.david.ticketmastertest.views.attractionslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.david.ticketmastertest.R
import com.david.ticketmastertest.models.events.Events
import java.util.ArrayList

class EventsAdapter(
    @LayoutRes private val itemLayoutRes: Int = R.layout.events_item_layout,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val eventsList = ArrayList<Events>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EventsHolder(
            LayoutInflater.from(parent.context).inflate(itemLayoutRes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as EventsHolder).bind(eventsList[position], listener)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    fun setAttractions(attractions: List<Events>) {
        eventsList.clear()
        eventsList.addAll(attractions)
        notifyDataSetChanged()
    }
}