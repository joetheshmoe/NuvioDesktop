package com.nuvio.app.features.trakt

actual object TraktPlatformClock {
    actual fun nowEpochMs(): Long = System.currentTimeMillis()
    actual fun parseIsoDateTimeToEpochMs(value: String): Long? {
        return try { java.time.Instant.parse(value).toEpochMilli() } catch (_: Exception) { null }
    }
    actual fun availableProcessors(): Int = Runtime.getRuntime().availableProcessors()
}
