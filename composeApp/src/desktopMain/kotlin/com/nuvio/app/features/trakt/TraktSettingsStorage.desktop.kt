package com.nuvio.app.features.trakt

import com.nuvio.app.DesktopStorage

internal actual object TraktSettingsStorage {
    private const val KEY = "trakt_settings_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
