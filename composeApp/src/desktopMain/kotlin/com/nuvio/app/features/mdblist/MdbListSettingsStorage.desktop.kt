package com.nuvio.app.features.mdblist

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object MdbListSettingsStorage {
    private fun k(p: String) = "mdblist_$p"
    actual fun loadEnabled(): Boolean? = DesktopStorage.getBoolean(k("enabled"))
    actual fun saveEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("enabled"), enabled)
    actual fun loadApiKey(): String? = DesktopStorage.get(k("api_key"))
    actual fun saveApiKey(apiKey: String) = DesktopStorage.put(k("api_key"), apiKey)
    actual fun loadUseImdb(): Boolean? = DesktopStorage.getBoolean(k("use_imdb"))
    actual fun saveUseImdb(enabled: Boolean) = DesktopStorage.putBoolean(k("use_imdb"), enabled)
    actual fun loadUseTmdb(): Boolean? = DesktopStorage.getBoolean(k("use_tmdb"))
    actual fun saveUseTmdb(enabled: Boolean) = DesktopStorage.putBoolean(k("use_tmdb"), enabled)
    actual fun loadUseTomatoes(): Boolean? = DesktopStorage.getBoolean(k("use_tomatoes"))
    actual fun saveUseTomatoes(enabled: Boolean) = DesktopStorage.putBoolean(k("use_tomatoes"), enabled)
    actual fun loadUseMetacritic(): Boolean? = DesktopStorage.getBoolean(k("use_metacritic"))
    actual fun saveUseMetacritic(enabled: Boolean) = DesktopStorage.putBoolean(k("use_metacritic"), enabled)
    actual fun loadUseTrakt(): Boolean? = DesktopStorage.getBoolean(k("use_trakt"))
    actual fun saveUseTrakt(enabled: Boolean) = DesktopStorage.putBoolean(k("use_trakt"), enabled)
    actual fun loadUseLetterboxd(): Boolean? = DesktopStorage.getBoolean(k("use_letterboxd"))
    actual fun saveUseLetterboxd(enabled: Boolean) = DesktopStorage.putBoolean(k("use_letterboxd"), enabled)
    actual fun loadUseAudience(): Boolean? = DesktopStorage.getBoolean(k("use_audience"))
    actual fun saveUseAudience(enabled: Boolean) = DesktopStorage.putBoolean(k("use_audience"), enabled)
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
