package com.david.ticketmastertest

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.prepareForTest(){
    run {
        measure(0, 0)
        layout(0, 0, 100, 1000)
    }
}