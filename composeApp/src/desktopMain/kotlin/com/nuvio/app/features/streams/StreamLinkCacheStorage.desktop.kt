package com.nuvio.app.features.streams

import com.nuvio.app.DesktopStorage

internal actual object StreamLinkCacheStorage {
    private fun key(hashedKey: String) = "link_cache_$hashedKey"
    actual fun loadEntry(hashedKey: String): String? = DesktopStorage.get(key(hashedKey))
    actual fun saveEntry(hashedKey: String, payload: String) = DesktopStorage.put(key(hashedKey), payload)
    actual fun removeEntry(hashedKey: String) = DesktopStorage.remove(key(hashedKey))
}
