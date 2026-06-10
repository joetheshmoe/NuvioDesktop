package com.nuvio.app.features.streams

import com.nuvio.app.DesktopStorage

internal actual object BingeGroupCacheStorage {
    private fun key(hashedKey: String) = "binge_cache_$hashedKey"
    actual fun load(hashedKey: String): String? = DesktopStorage.get(key(hashedKey))
    actual fun save(hashedKey: String, value: String) = DesktopStorage.put(key(hashedKey), value)
    actual fun remove(hashedKey: String) = DesktopStorage.remove(key(hashedKey))
}
