package com.nuvio.app.features.notifications

import com.nuvio.app.DesktopStorage

internal actual object EpisodeReleaseNotificationsStorage {
    private const val KEY = "episode_release_notifications_payload"
    actual fun loadPayload(): String? = DesktopStorage.get(KEY)
    actual fun savePayload(payload: String) = DesktopStorage.put(KEY, payload)
}
