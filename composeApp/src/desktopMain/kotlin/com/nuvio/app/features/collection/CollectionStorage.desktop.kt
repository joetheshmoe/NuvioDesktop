package com.nuvio.app.features.collection

import com.nuvio.app.DesktopStorage

internal actual object CollectionStorage {
    private const val KEY = "collection_payload"

    actual fun loadPayload(): String? = DesktopStorage.get(KEY)

    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
