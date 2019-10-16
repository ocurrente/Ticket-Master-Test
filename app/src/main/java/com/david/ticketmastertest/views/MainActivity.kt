package com.david.ticketmastertest.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.david.ticketmastertest.R
import com.david.ticketmastertest.views.attractionsdetails.AttractionDetailsFragment
import com.david.ticketmastertest.views.attractionslist.AttractionsListFragment
import com.david.ticketmastertest.views.viewmodels.AttractionViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.reflect.KClass

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AttractionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!this::viewModel.isInitialized) {
            viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(AttractionViewModel::class.java)
        }

        setObservers()

        changeFragment(AttractionsListFragment::class, false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setObservers() {
        viewModel.currentFragment.observe(this, Observer {
            changeFragment(it!!, true)
        })
    }

    private fun changeFragment(
        fragmentClass: KClass<out Fragment>,
        addToBackStack: Boolean
    ): Boolean {

        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(fragmentClass.toString())

        if (fragment == null) {
            fragment = when (fragmentClass) {
                AttractionsListFragment::class -> {
                    AttractionsListFragment()
                }
                AttractionDetailsFragment::class -> {
                    AttractionDetailsFragment()
                }
                else -> {
                    null
                }
            }
        }

        if (fragment == null) {
            Log.e("MainActivity", "FragmentId ($fragmentClass) not supported for this operation.")
            return false
        }

        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment, fragmentClass.toString())

        if (addToBackStack) {
            transaction.addToBackStack(fragmentClass.toString())
        }

        transaction.commit()

        return true
    }
}
