package com.nuvio.app.features.downloads

import com.nuvio.app.DesktopStorage

internal actual object DownloadsStorage {
    private const val KEY = "downloads_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
