package com.david.ticketmastertest.views.attractionsdetails.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.david.ticketmastertest.models.events.Venues
import kotlinx.android.synthetic.main.venues_item_layout.view.*

class VenuesHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        item: Venues
    ) = with(itemView) {

        itemView.nameTextView.text = item.name
        itemView.cityTextView.text = item.city.name
        itemView.countryTextView.text = item.country.name
        itemView.addressTextView.text = item.address.line1
    }
}