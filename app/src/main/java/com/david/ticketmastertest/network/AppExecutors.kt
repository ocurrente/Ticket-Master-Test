package com.david.ticketmastertest.network

import java.util.concurrent.Executor

open class AppExecutors constructor(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor
) {

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }
}