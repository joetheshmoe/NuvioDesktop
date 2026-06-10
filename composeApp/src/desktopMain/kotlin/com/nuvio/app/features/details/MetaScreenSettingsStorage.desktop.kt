package com.nuvio.app.features.details

import com.nuvio.app.DesktopStorage

internal actual object MetaScreenSettingsStorage {
    private const val KEY = "meta_screen_settings_payload"

    actual fun loadPayload(): String? = DesktopStorage.get(KEY)

    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
