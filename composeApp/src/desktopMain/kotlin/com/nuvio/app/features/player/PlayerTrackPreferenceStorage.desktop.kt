package com.nuvio.app.features.player

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.jsonObject

internal actual object PlayerTrackPreferenceStorage {
    private fun key(contentId: String) = "track_pref_$contentId"
    private val json = Json { ignoreUnknownKeys = true }

    actual fun load(contentId: String): PersistedPlayerTrackPreference? {
        val raw = DesktopStorage.get(key(contentId)) ?: return null
        return try {
            val obj = json.parseToJsonElement(raw).jsonObject
            PersistedPlayerTrackPreference(
                subtitleType = obj["subtitleType"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                subtitleLanguage = obj["subtitleLanguage"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                subtitleName = obj["subtitleName"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                subtitleTrackId = obj["subtitleTrackId"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                addonSubtitleId = obj["addonSubtitleId"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                addonSubtitleUrl = obj["addonSubtitleUrl"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                addonSubtitleAddonName = obj["addonSubtitleAddonName"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                audioLanguage = obj["audioLanguage"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                audioName = obj["audioName"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
                audioTrackId = obj["audioTrackId"]?.let { if (it is kotlinx.serialization.json.JsonPrimitive) it.content else null },
            )
        } catch (_: Exception) { null }
    }

    actual fun save(contentId: String, preference: PersistedPlayerTrackPreference) {
        val obj = buildJsonObject {
            preference.subtitleType?.let { put("subtitleType", it) }
            preference.subtitleLanguage?.let { put("subtitleLanguage", it) }
            preference.subtitleName?.let { put("subtitleName", it) }
            preference.subtitleTrackId?.let { put("subtitleTrackId", it) }
            preference.addonSubtitleId?.let { put("addonSubtitleId", it) }
            preference.addonSubtitleUrl?.let { put("addonSubtitleUrl", it) }
            preference.addonSubtitleAddonName?.let { put("addonSubtitleAddonName", it) }
            preference.audioLanguage?.let { put("audioLanguage", it) }
            preference.audioName?.let { put("audioName", it) }
            preference.audioTrackId?.let { put("audioTrackId", it) }
        }
        DesktopStorage.put(key(contentId), json.encodeToString(JsonObject.serializer(), obj))
    }

    actual fun loadSubtitleDelayMs(videoId: String): Int? = DesktopStorage.getInt("sub_delay_$videoId")

    actual fun saveSubtitleDelayMs(videoId: String, delayMs: Int) = DesktopStorage.putInt("sub_delay_$videoId", delayMs)
}
