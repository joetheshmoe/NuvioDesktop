package com.nuvio.app.features.home

import com.nuvio.app.DesktopStorage

internal actual object HomeCatalogSettingsStorage {
    private const val KEY = "home_catalog_settings_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
