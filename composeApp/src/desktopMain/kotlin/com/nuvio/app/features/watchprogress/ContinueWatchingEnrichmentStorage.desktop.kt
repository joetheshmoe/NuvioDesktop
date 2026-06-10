package com.nuvio.app.features.watchprogress

import com.nuvio.app.DesktopStorage

internal actual object ContinueWatchingEnrichmentStorage {
    private fun key(k: String) = "cw_enrich_$k"
    actual fun loadPayload(key: String): String? = DesktopStorage.get(key(key))
    actual fun savePayload(key: String, payload: String) = DesktopStorage.put(key(key), payload)
    actual fun removePayload(key: String) = DesktopStorage.remove(key(key))
}
