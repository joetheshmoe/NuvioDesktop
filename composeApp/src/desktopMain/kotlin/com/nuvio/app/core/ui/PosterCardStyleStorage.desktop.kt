package com.nuvio.app.core.ui

import com.nuvio.app.DesktopStorage

internal actual object PosterCardStyleStorage {
    private const val KEY = "poster_card_style_payload"

    actual fun loadPayload(): String? = DesktopStorage.get(KEY)

    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
