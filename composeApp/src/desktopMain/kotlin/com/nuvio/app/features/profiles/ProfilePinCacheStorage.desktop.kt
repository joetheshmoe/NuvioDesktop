package com.nuvio.app.features.profiles

import com.nuvio.app.DesktopStorage

internal actual object ProfilePinCacheStorage {
    private fun key(profileIndex: Int) = "profile_pin_cache_$profileIndex"
    actual fun loadPayload(profileIndex: Int): String? = DesktopStorage.get(key(profileIndex))
    actual fun savePayload(profileIndex: Int, payload: String) = DesktopStorage.put(key(profileIndex), payload)
    actual fun removePayload(profileIndex: Int) = DesktopStorage.remove(key(profileIndex))
}
