package com.nuvio.app.features.trakt

import com.nuvio.app.DesktopStorage

internal actual object TraktLibraryStorage {
    private const val KEY = "trakt_library_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
