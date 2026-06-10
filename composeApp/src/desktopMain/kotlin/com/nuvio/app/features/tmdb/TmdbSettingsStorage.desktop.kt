package com.nuvio.app.features.tmdb

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object TmdbSettingsStorage {
    private fun k(p: String) = "tmdb_$p"
    actual fun loadEnabled(): Boolean? = DesktopStorage.getBoolean(k("enabled"))
    actual fun saveEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("enabled"), enabled)
    actual fun loadApiKey(): String? = DesktopStorage.get(k("api_key"))
    actual fun saveApiKey(apiKey: String) = DesktopStorage.put(k("api_key"), apiKey)
    actual fun loadLanguage(): String? = DesktopStorage.get(k("language"))
    actual fun saveLanguage(language: String) = DesktopStorage.put(k("language"), language)
    actual fun loadUseTrailers(): Boolean? = DesktopStorage.getBoolean(k("trailers"))
    actual fun saveUseTrailers(enabled: Boolean) = DesktopStorage.putBoolean(k("trailers"), enabled)
    actual fun loadUseArtwork(): Boolean? = DesktopStorage.getBoolean(k("artwork"))
    actual fun saveUseArtwork(enabled: Boolean) = DesktopStorage.putBoolean(k("artwork"), enabled)
    actual fun loadUseBasicInfo(): Boolean? = DesktopStorage.getBoolean(k("basic_info"))
    actual fun saveUseBasicInfo(enabled: Boolean) = DesktopStorage.putBoolean(k("basic_info"), enabled)
    actual fun loadUseDetails(): Boolean? = DesktopStorage.getBoolean(k("details"))
    actual fun saveUseDetails(enabled: Boolean) = DesktopStorage.putBoolean(k("details"), enabled)
    actual fun loadUseCredits(): Boolean? = DesktopStorage.getBoolean(k("credits"))
    actual fun saveUseCredits(enabled: Boolean) = DesktopStorage.putBoolean(k("credits"), enabled)
    actual fun loadUseProductions(): Boolean? = DesktopStorage.getBoolean(k("productions"))
    actual fun saveUseProductions(enabled: Boolean) = DesktopStorage.putBoolean(k("productions"), enabled)
    actual fun loadUseNetworks(): Boolean? = DesktopStorage.getBoolean(k("networks"))
    actual fun saveUseNetworks(enabled: Boolean) = DesktopStorage.putBoolean(k("networks"), enabled)
    actual fun loadUseEpisodes(): Boolean? = DesktopStorage.getBoolean(k("episodes"))
    actual fun saveUseEpisodes(enabled: Boolean) = DesktopStorage.putBoolean(k("episodes"), enabled)
    actual fun loadUseSeasonPosters(): Boolean? = DesktopStorage.getBoolean(k("season_posters"))
    actual fun saveUseSeasonPosters(enabled: Boolean) = DesktopStorage.putBoolean(k("season_posters"), enabled)
    actual fun loadUseMoreLikeThis(): Boolean? = DesktopStorage.getBoolean(k("more_like_this"))
    actual fun saveUseMoreLikeThis(enabled: Boolean) = DesktopStorage.putBoolean(k("more_like_this"), enabled)
    actual fun loadUseCollections(): Boolean? = DesktopStorage.getBoolean(k("collections"))
    actual fun saveUseCollections(enabled: Boolean) = DesktopStorage.putBoolean(k("collections"), enabled)
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
