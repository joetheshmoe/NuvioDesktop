package com.nuvio.app.features.search

import com.nuvio.app.DesktopStorage

internal actual object SearchHistoryStorage {
    private const val KEY = "search_history_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
