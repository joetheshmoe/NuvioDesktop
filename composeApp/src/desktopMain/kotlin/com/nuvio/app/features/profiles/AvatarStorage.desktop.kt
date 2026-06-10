package com.nuvio.app.features.profiles

import com.nuvio.app.DesktopStorage

internal actual object AvatarStorage {
    private const val KEY = "avatar_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
