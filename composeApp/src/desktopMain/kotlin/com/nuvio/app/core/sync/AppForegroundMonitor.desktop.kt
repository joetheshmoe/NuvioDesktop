package com.nuvio.app.core.sync

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOf

internal actual object AppForegroundMonitor {
    // On desktop, there's no meaningful "foreground" event separate from app lifecycle.
    // We emit a single event on initialization and then nothing.
    private val _events: Flow<Unit> = flowOf(Unit)

    actual fun events(): Flow<Unit> = _events
}
