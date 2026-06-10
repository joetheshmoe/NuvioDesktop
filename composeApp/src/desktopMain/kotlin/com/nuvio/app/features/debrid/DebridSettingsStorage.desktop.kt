package com.nuvio.app.features.debrid

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

internal actual object DebridSettingsStorage {
    private fun k(prefix: String) = "debrid_$prefix"

    actual fun loadEnabled(): Boolean? = DesktopStorage.getBoolean(k("enabled"))
    actual fun saveEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("enabled"), enabled)
    actual fun loadCloudLibraryEnabled(): Boolean? = DesktopStorage.getBoolean(k("cloud_library_enabled"))
    actual fun saveCloudLibraryEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("cloud_library_enabled"), enabled)
    actual fun loadPreferredResolverProviderId(): String? = DesktopStorage.get(k("preferred_resolver"))
    actual fun savePreferredResolverProviderId(providerId: String) = DesktopStorage.put(k("preferred_resolver"), providerId)
    actual fun loadProviderApiKey(providerId: String): String? = DesktopStorage.get(k("api_key_$providerId"))
    actual fun saveProviderApiKey(providerId: String, apiKey: String) = DesktopStorage.put(k("api_key_$providerId"), apiKey)
    actual fun loadTorboxApiKey(): String? = DesktopStorage.get(k("torbox_api_key"))
    actual fun saveTorboxApiKey(apiKey: String) = DesktopStorage.put(k("torbox_api_key"), apiKey)
    actual fun loadRealDebridApiKey(): String? = DesktopStorage.get(k("realdebrid_api_key"))
    actual fun saveRealDebridApiKey(apiKey: String) = DesktopStorage.put(k("realdebrid_api_key"), apiKey)
    actual fun loadInstantPlaybackPreparationLimit(): Int? = DesktopStorage.getInt(k("instant_playback_limit"))
    actual fun saveInstantPlaybackPreparationLimit(limit: Int) = DesktopStorage.putInt(k("instant_playback_limit"), limit)
    actual fun loadStreamMaxResults(): Int? = DesktopStorage.getInt(k("stream_max_results"))
    actual fun saveStreamMaxResults(maxResults: Int) = DesktopStorage.putInt(k("stream_max_results"), maxResults)
    actual fun loadStreamSortMode(): String? = DesktopStorage.get(k("stream_sort_mode"))
    actual fun saveStreamSortMode(mode: String) = DesktopStorage.put(k("stream_sort_mode"), mode)
    actual fun loadStreamMinimumQuality(): String? = DesktopStorage.get(k("stream_min_quality"))
    actual fun saveStreamMinimumQuality(quality: String) = DesktopStorage.put(k("stream_min_quality"), quality)
    actual fun loadStreamDolbyVisionFilter(): String? = DesktopStorage.get(k("stream_dv_filter"))
    actual fun saveStreamDolbyVisionFilter(filter: String) = DesktopStorage.put(k("stream_dv_filter"), filter)
    actual fun loadStreamHdrFilter(): String? = DesktopStorage.get(k("stream_hdr_filter"))
    actual fun saveStreamHdrFilter(filter: String) = DesktopStorage.put(k("stream_hdr_filter"), filter)
    actual fun loadStreamCodecFilter(): String? = DesktopStorage.get(k("stream_codec_filter"))
    actual fun saveStreamCodecFilter(filter: String) = DesktopStorage.put(k("stream_codec_filter"), filter)
    actual fun loadStreamPreferences(): String? = DesktopStorage.get(k("stream_preferences"))
    actual fun saveStreamPreferences(preferences: String) = DesktopStorage.put(k("stream_preferences"), preferences)
    actual fun loadStreamNameTemplate(): String? = DesktopStorage.get(k("stream_name_template"))
    actual fun saveStreamNameTemplate(template: String) = DesktopStorage.put(k("stream_name_template"), template)
    actual fun loadStreamDescriptionTemplate(): String? = DesktopStorage.get(k("stream_desc_template"))
    actual fun saveStreamDescriptionTemplate(template: String) = DesktopStorage.put(k("stream_desc_template"), template)

    actual fun exportToSyncPayload(): JsonObject {
        val json = Json { ignoreUnknownKeys = true }
        return buildJsonObject {
            // Export a minimal sync payload
        }
    }

    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
