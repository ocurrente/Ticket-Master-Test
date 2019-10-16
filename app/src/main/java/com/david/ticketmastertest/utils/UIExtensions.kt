package com.david.ticketmastertest.utils

import android.content.Context
import android.widget.Toast

fun String.showAsToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}