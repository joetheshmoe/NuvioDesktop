package com.nuvio.app.features.player

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object PlayerSettingsStorage {
    private fun k(p: String) = "player_$p"

    actual fun loadShowLoadingOverlay(): Boolean? = DesktopStorage.getBoolean(k("show_loading"))
    actual fun saveShowLoadingOverlay(enabled: Boolean) = DesktopStorage.putBoolean(k("show_loading"), enabled)
    actual fun loadResizeMode(): String? = DesktopStorage.get(k("resize_mode"))
    actual fun saveResizeMode(mode: String) = DesktopStorage.put(k("resize_mode"), mode)
    actual fun loadHoldToSpeedEnabled(): Boolean? = DesktopStorage.getBoolean(k("hold_speed_enabled"))
    actual fun saveHoldToSpeedEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("hold_speed_enabled"), enabled)
    actual fun loadHoldToSpeedValue(): Float? = DesktopStorage.getFloat(k("hold_speed_value"))
    actual fun saveHoldToSpeedValue(speed: Float) = DesktopStorage.putFloat(k("hold_speed_value"), speed)
    actual fun loadExternalPlayerEnabled(): Boolean? = DesktopStorage.getBoolean(k("external_player_enabled"))
    actual fun saveExternalPlayerEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("external_player_enabled"), enabled)
    actual fun loadExternalPlayerForwardSubtitles(): Boolean? = DesktopStorage.getBoolean(k("ext_player_subs"))
    actual fun saveExternalPlayerForwardSubtitles(enabled: Boolean) = DesktopStorage.putBoolean(k("ext_player_subs"), enabled)
    actual fun loadExternalPlayerId(): String? = DesktopStorage.get(k("external_player_id"))
    actual fun saveExternalPlayerId(playerId: String?) = if (playerId != null) DesktopStorage.put(k("external_player_id"), playerId) else DesktopStorage.remove(k("external_player_id"))
    actual fun loadPreferredAudioLanguage(): String? = DesktopStorage.get(k("pref_audio"))
    actual fun savePreferredAudioLanguage(language: String) = DesktopStorage.put(k("pref_audio"), language)
    actual fun loadSecondaryPreferredAudioLanguage(): String? = DesktopStorage.get(k("pref_audio_2"))
    actual fun saveSecondaryPreferredAudioLanguage(language: String?) = if (language != null) DesktopStorage.put(k("pref_audio_2"), language) else DesktopStorage.remove(k("pref_audio_2"))
    actual fun loadPreferredSubtitleLanguage(): String? = DesktopStorage.get(k("pref_subs"))
    actual fun savePreferredSubtitleLanguage(language: String) = DesktopStorage.put(k("pref_subs"), language)
    actual fun loadSecondaryPreferredSubtitleLanguage(): String? = DesktopStorage.get(k("pref_subs_2"))
    actual fun saveSecondaryPreferredSubtitleLanguage(language: String?) = if (language != null) DesktopStorage.put(k("pref_subs_2"), language) else DesktopStorage.remove(k("pref_subs_2"))
    actual fun loadSubtitleTextColor(): String? = DesktopStorage.get(k("sub_color"))
    actual fun saveSubtitleTextColor(colorHex: String) = DesktopStorage.put(k("sub_color"), colorHex)
    actual fun loadSubtitleBackgroundColor(): String? = DesktopStorage.get(k("sub_bg_color"))
    actual fun saveSubtitleBackgroundColor(colorHex: String) = DesktopStorage.put(k("sub_bg_color"), colorHex)
    actual fun loadSubtitleOutlineColor(): String? = DesktopStorage.get(k("sub_outline_color"))
    actual fun saveSubtitleOutlineColor(colorHex: String) = DesktopStorage.put(k("sub_outline_color"), colorHex)
    actual fun loadSubtitleOutlineEnabled(): Boolean? = DesktopStorage.getBoolean(k("sub_outline_enabled"))
    actual fun saveSubtitleOutlineEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("sub_outline_enabled"), enabled)
    actual fun loadSubtitleOutlineWidth(): Int? = DesktopStorage.getInt(k("sub_outline_width"))
    actual fun saveSubtitleOutlineWidth(width: Int) = DesktopStorage.putInt(k("sub_outline_width"), width)
    actual fun loadSubtitleBold(): Boolean? = DesktopStorage.getBoolean(k("sub_bold"))
    actual fun saveSubtitleBold(enabled: Boolean) = DesktopStorage.putBoolean(k("sub_bold"), enabled)
    actual fun loadSubtitleFontSizeSp(): Int? = DesktopStorage.getInt(k("sub_font_size"))
    actual fun saveSubtitleFontSizeSp(fontSizeSp: Int) = DesktopStorage.putInt(k("sub_font_size"), fontSizeSp)
    actual fun loadSubtitleBottomOffset(): Int? = DesktopStorage.getInt(k("sub_bottom_offset"))
    actual fun saveSubtitleBottomOffset(bottomOffset: Int) = DesktopStorage.putInt(k("sub_bottom_offset"), bottomOffset)
    actual fun loadSubtitleUseForcedSubtitles(): Boolean? = DesktopStorage.getBoolean(k("sub_forced"))
    actual fun saveSubtitleUseForcedSubtitles(enabled: Boolean) = DesktopStorage.putBoolean(k("sub_forced"), enabled)
    actual fun loadSubtitleShowOnlyPreferredLanguages(): Boolean? = DesktopStorage.getBoolean(k("sub_only_preferred"))
    actual fun saveSubtitleShowOnlyPreferredLanguages(enabled: Boolean) = DesktopStorage.putBoolean(k("sub_only_preferred"), enabled)
    actual fun loadAddonSubtitleStartupMode(): String? = DesktopStorage.get(k("addon_sub_mode"))
    actual fun saveAddonSubtitleStartupMode(mode: String) = DesktopStorage.put(k("addon_sub_mode"), mode)
    actual fun loadStreamReuseLastLinkEnabled(): Boolean? = DesktopStorage.getBoolean(k("reuse_link"))
    actual fun saveStreamReuseLastLinkEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("reuse_link"), enabled)
    actual fun loadStreamReuseLastLinkCacheHours(): Int? = DesktopStorage.getInt(k("reuse_link_hours"))
    actual fun saveStreamReuseLastLinkCacheHours(hours: Int) = DesktopStorage.putInt(k("reuse_link_hours"), hours)
    actual fun loadDecoderPriority(): Int? = DesktopStorage.getInt(k("decoder_priority"))
    actual fun saveDecoderPriority(priority: Int) = DesktopStorage.putInt(k("decoder_priority"), priority)
    actual fun loadMapDV7ToHevc(): Boolean? = DesktopStorage.getBoolean(k("map_dv7"))
    actual fun saveMapDV7ToHevc(enabled: Boolean) = DesktopStorage.putBoolean(k("map_dv7"), enabled)
    actual fun loadTunnelingEnabled(): Boolean? = DesktopStorage.getBoolean(k("tunneling"))
    actual fun saveTunnelingEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("tunneling"), enabled)
    actual fun loadStreamAutoPlayMode(): String? = DesktopStorage.get(k("autoplay_mode"))
    actual fun saveStreamAutoPlayMode(mode: String) = DesktopStorage.put(k("autoplay_mode"), mode)
    actual fun loadStreamAutoPlaySource(): String? = DesktopStorage.get(k("autoplay_source"))
    actual fun saveStreamAutoPlaySource(source: String) = DesktopStorage.put(k("autoplay_source"), source)
    actual fun loadStreamAutoPlaySelectedAddons(): Set<String>? = DesktopStorage.get(k("autoplay_addons"))?.split(",")?.toSet()?.filter { it.isNotBlank() }?.toSet()
    actual fun saveStreamAutoPlaySelectedAddons(addons: Set<String>) = DesktopStorage.put(k("autoplay_addons"), addons.joinToString(","))
    actual fun loadStreamAutoPlaySelectedPlugins(): Set<String>? = DesktopStorage.get(k("autoplay_plugins"))?.split(",")?.toSet()?.filter { it.isNotBlank() }?.toSet()
    actual fun saveStreamAutoPlaySelectedPlugins(plugins: Set<String>) = DesktopStorage.put(k("autoplay_plugins"), plugins.joinToString(","))
    actual fun loadStreamAutoPlayRegex(): String? = DesktopStorage.get(k("autoplay_regex"))
    actual fun saveStreamAutoPlayRegex(regex: String) = DesktopStorage.put(k("autoplay_regex"), regex)
    actual fun loadStreamAutoPlayTimeoutSeconds(): Int? = DesktopStorage.getInt(k("autoplay_timeout"))
    actual fun saveStreamAutoPlayTimeoutSeconds(seconds: Int) = DesktopStorage.putInt(k("autoplay_timeout"), seconds)
    actual fun loadSkipIntroEnabled(): Boolean? = DesktopStorage.getBoolean(k("skip_intro"))
    actual fun saveSkipIntroEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("skip_intro"), enabled)
    actual fun loadAnimeSkipEnabled(): Boolean? = DesktopStorage.getBoolean(k("anime_skip"))
    actual fun saveAnimeSkipEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("anime_skip"), enabled)
    actual fun loadAnimeSkipClientId(): String? = DesktopStorage.get(k("anime_skip_client_id"))
    actual fun saveAnimeSkipClientId(clientId: String) = DesktopStorage.put(k("anime_skip_client_id"), clientId)
    actual fun loadIntroDbApiKey(): String? = DesktopStorage.get(k("introdb_key"))
    actual fun saveIntroDbApiKey(apiKey: String) = DesktopStorage.put(k("introdb_key"), apiKey)
    actual fun loadIntroSubmitEnabled(): Boolean? = DesktopStorage.getBoolean(k("intro_submit"))
    actual fun saveIntroSubmitEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("intro_submit"), enabled)
    actual fun loadStreamAutoPlayNextEpisodeEnabled(): Boolean? = DesktopStorage.getBoolean(k("autoplay_next"))
    actual fun saveStreamAutoPlayNextEpisodeEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("autoplay_next"), enabled)
    actual fun loadStreamAutoPlayPreferBingeGroup(): Boolean? = DesktopStorage.getBoolean(k("autoplay_binge"))
    actual fun saveStreamAutoPlayPreferBingeGroup(enabled: Boolean) = DesktopStorage.putBoolean(k("autoplay_binge"), enabled)
    actual fun loadStreamAutoPlayReuseBingeGroup(): Boolean? = DesktopStorage.getBoolean(k("autoplay_reuse_binge"))
    actual fun saveStreamAutoPlayReuseBingeGroup(enabled: Boolean) = DesktopStorage.putBoolean(k("autoplay_reuse_binge"), enabled)
    actual fun loadNextEpisodeThresholdMode(): String? = DesktopStorage.get(k("next_ep_mode"))
    actual fun saveNextEpisodeThresholdMode(mode: String) = DesktopStorage.put(k("next_ep_mode"), mode)
    actual fun loadNextEpisodeThresholdPercent(): Float? = DesktopStorage.getFloat(k("next_ep_pct"))
    actual fun saveNextEpisodeThresholdPercent(percent: Float) = DesktopStorage.putFloat(k("next_ep_pct"), percent)
    actual fun loadNextEpisodeThresholdMinutesBeforeEnd(): Float? = DesktopStorage.getFloat(k("next_ep_min_before"))
    actual fun saveNextEpisodeThresholdMinutesBeforeEnd(minutes: Float) = DesktopStorage.putFloat(k("next_ep_min_before"), minutes)
    actual fun loadUseLibass(): Boolean? = DesktopStorage.getBoolean(k("use_libass"))
    actual fun saveUseLibass(enabled: Boolean) = DesktopStorage.putBoolean(k("use_libass"), enabled)
    actual fun loadLibassRenderType(): String? = DesktopStorage.get(k("libass_render"))
    actual fun saveLibassRenderType(renderType: String) = DesktopStorage.put(k("libass_render"), renderType)
    actual fun loadIosVideoOutputPreset(): String? = null
    actual fun saveIosVideoOutputPreset(preset: String) { }
    actual fun loadIosToneMappingMode(): String? = null
    actual fun saveIosToneMappingMode(mode: String) { }
    actual fun loadIosTargetPrimaries(): String? = null
    actual fun saveIosTargetPrimaries(primaries: String) { }
    actual fun loadIosTargetTransfer(): String? = null
    actual fun saveIosTargetTransfer(transfer: String) { }
    actual fun loadIosHardwareDecoderMode(): String? = null
    actual fun saveIosHardwareDecoderMode(mode: String) { }
    actual fun loadIosAudioOutputMode(): String? = null
    actual fun saveIosAudioOutputMode(mode: String) { }
    actual fun loadIosExtendedDynamicRangeEnabled(): Boolean? = null
    actual fun saveIosExtendedDynamicRangeEnabled(enabled: Boolean) { }
    actual fun loadIosTargetColorspaceHintEnabled(): Boolean? = null
    actual fun saveIosTargetColorspaceHintEnabled(enabled: Boolean) { }
    actual fun loadIosHdrComputePeakEnabled(): Boolean? = null
    actual fun saveIosHdrComputePeakEnabled(enabled: Boolean) { }
    actual fun loadIosDebandEnabled(): Boolean? = null
    actual fun saveIosDebandEnabled(enabled: Boolean) { }
    actual fun loadIosInterpolationEnabled(): Boolean? = null
    actual fun saveIosInterpolationEnabled(enabled: Boolean) { }
    actual fun loadIosBrightness(): Int? = null
    actual fun saveIosBrightness(value: Int) { }
    actual fun loadIosContrast(): Int? = null
    actual fun saveIosContrast(value: Int) { }
    actual fun loadIosSaturation(): Int? = null
    actual fun saveIosSaturation(value: Int) { }
    actual fun loadIosGamma(): Int? = null
    actual fun saveIosGamma(value: Int) { }
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
