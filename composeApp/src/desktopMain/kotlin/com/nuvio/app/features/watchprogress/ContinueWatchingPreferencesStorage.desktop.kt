package com.nuvio.app.features.watchprogress

import com.nuvio.app.DesktopStorage

internal actual object ContinueWatchingPreferencesStorage {
    private const val KEY = "continue_watching_prefs_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
