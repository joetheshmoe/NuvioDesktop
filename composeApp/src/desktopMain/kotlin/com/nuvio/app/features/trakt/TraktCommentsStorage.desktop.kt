package com.nuvio.app.features.trakt

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object TraktCommentsStorage {
    private fun k(p: String) = "trakt_comments_$p"
    actual fun loadEnabled(): Boolean? = DesktopStorage.getBoolean(k("enabled"))
    actual fun saveEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("enabled"), enabled)
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
