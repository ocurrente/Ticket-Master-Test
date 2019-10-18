package com.david.ticketmastertest.views.attractionslist.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.david.ticketmastertest.R
import com.david.ticketmastertest.models.events.Events
import kotlinx.android.synthetic.main.events_item_layout.view.*

class EventsHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        item: Events,
        listener: (String) -> Unit
    ) = with(itemView) {

        itemView.nameTextView.text = item.name
        itemView.dateTextView.text = item.dates.start.localDate

        if (item.images.isNotEmpty()) {
            Glide.with(context)
                .load(item.images[0].url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .placeholder(R.drawable.profile_placeholder)
                .into(avatarImageView)
        }

        itemView.setOnClickListener {
            listener(item.id)
        }
    }
}