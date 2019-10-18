package com.david.ticketmastertest.views.attractionslist

import android.os.Build
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import com.david.ticketmastertest.R
import com.david.ticketmastertest.TestModels
import com.david.ticketmastertest.prepareForTest
import com.david.ticketmastertest.views.viewmodels.AttractionViewModel
import com.nhaarman.mockitokotlin2.*
import kotlinx.android.synthetic.main.fragment_attractions.*
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class AttractionsListFragmentTest {

    private lateinit var scenario: FragmentScenario<AttractionsListFragment>
    private lateinit var viewModel: AttractionViewModel

    @Before
    fun setup() {

        viewModel = spy(AttractionViewModel(mock()))
        scenario = launchFragmentInContainer<AttractionsListFragment>(themeResId = R.style.AppTheme)
        scenario.onFragment {
            it.viewModel = viewModel
        }
    }

    @Test
    fun `RecyclerView should display item when added to adapter`() {
        scenario.onFragment {
            // Given
            it.eventsAdapter.setAttractions(listOf(TestModels.getEvent()))

            // When
            it.eventsRecyclerView.prepareForTest()

            // Then
            assertTrue(
                "Recycler view should have at least one child",
                it.eventsRecyclerView.childCount == 1
            )
        }
    }

    @Test
    fun `Search button should trigger attractions query`() {
        scenario.onFragment {
            // Given
            val artistToSearch = "The Doors"
            it.searchEditText.setText(artistToSearch)
            doNothing().`when`(viewModel).getAttractions(artistToSearch)
            doReturn(null).`when`(viewModel).getKeyword()

            // When
            it.searchButton.performClick()

            // Then
            verify(viewModel).getAttractions(artistToSearch)
        }
    }

    @Test
    fun `Search button should not trigger attractions query if there is no input`() {
        scenario.onFragment {
            // Given
            doReturn(null).`when`(viewModel).getKeyword()

            // When
            it.searchButton.performClick()

            // Then
            verify(viewModel, never()).getAttractions(any())
        }
    }

    @Test
    fun `attractions query should be triggered when there is an artist search on cache`() {
        scenario.onFragment {
            // Given
            val artistOnCache = "The Doors"
            doReturn(artistOnCache).`when`(viewModel).getKeyword()
            doNothing().`when`(viewModel).getAttractions(artistOnCache)

            // When
            it.searchCachedArtist()

            // Then
            verify(viewModel).getAttractions(artistOnCache)
        }
    }
}