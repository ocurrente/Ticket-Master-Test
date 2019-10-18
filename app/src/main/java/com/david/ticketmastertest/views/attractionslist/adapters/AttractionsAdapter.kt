package com.david.ticketmastertest.views.attractionslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.david.ticketmastertest.R
import com.david.ticketmastertest.models.events.Events
import java.util.ArrayList

class AttractionsAdapter(
    @LayoutRes private val itemLayoutRes: Int = R.layout.attractions_item_layout,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val attractionsList = ArrayList<Events>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AttractionsHolder(
            LayoutInflater.from(parent.context).inflate(itemLayoutRes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AttractionsHolder).bind(attractionsList[position], listener)
    }

    override fun getItemCount(): Int {
        return attractionsList.size
    }

    fun setAttractions(attractions: List<Events>) {
        attractionsList.clear()
        attractionsList.addAll(attractions)
        notifyDataSetChanged()
    }
}