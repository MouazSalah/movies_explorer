package com.areeb.moviesexplorer.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
fun CoroutineScope.delayWithAction(
    delayMillis: Long,
    action: () -> Unit
) {
    launch {
        delay(delayMillis)
        action()
    }
}
