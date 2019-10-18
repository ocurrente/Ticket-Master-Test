package com.david.ticketmastertest.views.attractionsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.david.ticketmastertest.R
import com.david.ticketmastertest.models.events.Events
import com.david.ticketmastertest.views.attractionsdetails.adapters.VenuesAdapter
import com.david.ticketmastertest.views.viewmodels.AttractionViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_attraction_detail.*
import kotlinx.android.synthetic.main.fragment_attraction_detail.myToolbar
import javax.inject.Inject

class AttractionDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: AttractionViewModel

    lateinit var venuesAdapter: VenuesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_attraction_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val compatActivity = (activity as? AppCompatActivity)
        compatActivity?.run {
            setSupportActionBar(myToolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                myToolbar.title = getString(R.string.fragment_attraction_detail_toolbar_title)
            }
        }

        if (!this::viewModel.isInitialized) {
            viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(AttractionViewModel::class.java)
        }

        setObserversFromViewModel()

        venuesAdapter = VenuesAdapter(R.layout.venues_item_layout)

        venuesRecyclerView.adapter = venuesAdapter

        venuesRecyclerView.layoutManager = LinearLayoutManager(context)
        venuesRecyclerView.hasFixedSize()

        viewModel.getAttractionDetails()
    }

    private fun setObserversFromViewModel() {
        viewModel.attractionDetails.observe(this.viewLifecycleOwner, Observer { event ->
            event?.let {
                bindViews(it)
            }
        })
        viewModel.isLoading.observe(this.viewLifecycleOwner, Observer {loaded ->
            loadingSpinner.visibility = if (loaded!!) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })
    }

    private fun bindViews(event: Events) {
        event.images.firstOrNull()?.let {
            Glide.with(this)
                .load(it.url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .placeholder(R.drawable.profile_placeholder)
                .into(coverImageView)
        }

        nameSearchTextView.text = event.name
        typeSearchTextView.text = event.type
        dateSearchTextView.text = event.dates.start.localDate

        venuesAdapter.setVenues(event.venuesEmbedded.venues)
    }
}