package com.nuvio.app.features.library

import com.nuvio.app.DesktopStorage

internal actual object LibraryStorage {
    private fun key(profileId: Int) = "library_payload_$profileId"
    actual fun loadPayload(profileId: Int): String? = DesktopStorage.get(key(profileId))
    actual fun savePayload(profileId: Int, payload: String) = DesktopStorage.put(key(profileId), payload)
}
