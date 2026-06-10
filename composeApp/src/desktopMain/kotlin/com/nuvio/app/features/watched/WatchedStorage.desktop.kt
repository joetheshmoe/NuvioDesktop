package com.nuvio.app.features.watched

import com.nuvio.app.DesktopStorage

actual object WatchedStorage {
    private fun key(profileId: Int) = "watched_payload_$profileId"
    actual fun loadPayload(profileId: Int): String? = DesktopStorage.get(key(profileId))
    actual fun savePayload(profileId: Int, payload: String) = DesktopStorage.put(key(profileId), payload)
}
