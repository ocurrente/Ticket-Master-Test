package com.david.ticketmastertest.views.attractionslist.adapters

import android.os.Build
import android.view.LayoutInflater
import androidx.test.core.app.ApplicationProvider
import com.david.ticketmastertest.R
import com.david.ticketmastertest.TestModels
import kotlinx.android.synthetic.main.events_item_layout.view.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class AttractionsHolderTest {

    private lateinit var holder: EventsHolder

    @Before
    fun setup() {

        val view = LayoutInflater
            .from(ApplicationProvider.getApplicationContext())
            .inflate(
                R.layout.events_item_layout,
                null,
                false
            )

        holder = EventsHolder(view)
    }

    @Test
    fun `Data should be set properly`() {
        // Given
        val name = "The Doors"
        val type = "2019-11-25"
        val item = TestModels.getEvent(
            name = name
        )

        // When
        holder.bind(item) {}

        // Then
        assertEquals(name, holder.itemView.nameTextView.text.toString())
        assertEquals(type, holder.itemView.dateTextView.text.toString())
    }
}