package com.nuvio.app.features.streams

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object StreamBadgeSettingsStorage {
    private const val KEY_RULES = "stream_badge_rules"
    private const val KEY_LEGACY = "stream_badge_legacy_rules"

    actual fun loadStreamBadgeRules(): String? = DesktopStorage.get(KEY_RULES)
    actual fun saveStreamBadgeRules(rules: String) = DesktopStorage.put(KEY_RULES, rules)
    actual fun loadShowFileSizeBadges(): Boolean? = DesktopStorage.getBoolean("show_file_size_badges")
    actual fun saveShowFileSizeBadges(enabled: Boolean) = DesktopStorage.putBoolean("show_file_size_badges", enabled)
    actual fun loadStreamBadgePlacement(): String? = DesktopStorage.get("stream_badge_placement")
    actual fun saveStreamBadgePlacement(placement: String) = DesktopStorage.put("stream_badge_placement", placement)
    actual fun loadLegacyDebridStreamBadgeRules(): String? = DesktopStorage.get(KEY_LEGACY)
    actual fun clearLegacyDebridStreamBadgeRules() = DesktopStorage.remove(KEY_LEGACY)
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
