package com.nuvio.app.features.watchprogress

import com.nuvio.app.DesktopStorage

internal actual object WatchProgressStorage {
    private fun key(profileId: Int) = "watch_progress_$profileId"
    actual fun loadPayload(profileId: Int): String? = DesktopStorage.get(key(profileId))
    actual fun savePayload(profileId: Int, payload: String) = DesktopStorage.put(key(profileId), payload)
}
