package com.david.ticketmastertest.views.attractionslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.ticketmastertest.R
import com.david.ticketmastertest.utils.showAsToast
import com.david.ticketmastertest.views.attractionsdetails.AttractionDetailsFragment
import com.david.ticketmastertest.views.attractionslist.adapters.EventsAdapter
import com.david.ticketmastertest.views.viewmodels.AttractionViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_attractions.*
import javax.inject.Inject

class AttractionsListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: AttractionViewModel

    lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val compatActivity = (activity as? AppCompatActivity)
        compatActivity?.run {
            setSupportActionBar(myToolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                myToolbar.title = getString(R.string.attractions_list_fragment_toolbar_title)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_attractions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!this::viewModel.isInitialized) {
            viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(AttractionViewModel::class.java)
        }

        setObserversFromViewModel()

        eventsRecyclerView.layoutManager = LinearLayoutManager(context)
        eventsRecyclerView.hasFixedSize()

        eventsAdapter = EventsAdapter(
            R.layout.events_item_layout
        ) { id ->
            viewModel.currentDetailsId.value = id
            viewModel.currentFragment.value = AttractionDetailsFragment::class
        }

        eventsRecyclerView.adapter = eventsAdapter

        searchButton.setOnClickListener {
            hideSoftKeyBoard(context!!, searchButton)
            val searchText = searchEditText.text
            if (!searchText.isNullOrEmpty()) {
                viewModel.getAttractions(searchText.toString())
                searchEditText.setText("")
            } else {
                getString(R.string.attractions_list_fragment_error_text).showAsToast(context!!)
            }
        }

        searchCachedArtist()
    }

    internal fun searchCachedArtist() {
        viewModel.getKeyword()?.let {
            viewModel.getAttractions(it)
        }
    }

    private fun setObserversFromViewModel() {
        viewModel.artistAttractions.observe(this.viewLifecycleOwner, Observer { list ->
            latestSearchTextView.visibility = if (list.isNotEmpty()) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
            eventsAdapter.setAttractions(list)
        })

        viewModel.isLoading.observe(this.viewLifecycleOwner, Observer { loaded ->
            loadingSpinner.visibility = if (loaded!!) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })
    }

    private fun hideSoftKeyBoard(context: Context, view: View) {
        try {
            val imm =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}