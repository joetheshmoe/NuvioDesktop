package com.nuvio.app.features.notifications

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

internal actual object EpisodeReleaseNotificationsClock {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.systemDefault())
    actual fun isoDateFromEpochMs(epochMs: Long): String =
        formatter.format(Instant.ofEpochMilli(epochMs))
}
