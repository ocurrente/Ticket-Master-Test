package com.david.ticketmastertest.views

import android.content.Intent
import android.os.Build
import com.david.ticketmastertest.R
import com.david.ticketmastertest.views.attractionslist.AttractionsListFragment
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var activity: MainActivity
    private lateinit var controller: ActivityController<MainActivity>

    @Before
    fun setup() {
        val intent = Intent()
        controller = Robolectric.buildActivity(MainActivity::class.java, intent).setup()
        activity = controller.get()
    }

    @Test
    fun `Should show list of attractions`() {
        // Given
        controller.resume().visible()

        // When
        val fragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        // Then
        assertTrue(fragment is AttractionsListFragment)
        assertTrue(fragment!!.isVisible)
    }
}
