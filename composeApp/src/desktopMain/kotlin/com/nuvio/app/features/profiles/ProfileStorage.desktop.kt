package com.nuvio.app.features.profiles

import com.nuvio.app.DesktopStorage

internal actual object ProfileStorage {
    private const val KEY = "profiles_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
