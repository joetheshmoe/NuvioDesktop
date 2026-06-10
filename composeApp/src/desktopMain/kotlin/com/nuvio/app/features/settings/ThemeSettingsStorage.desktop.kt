package com.nuvio.app.features.settings

import com.nuvio.app.DesktopStorage
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject

internal actual object ThemeSettingsStorage {
    private fun k(p: String) = "theme_$p"
    actual fun loadSelectedTheme(): String? = DesktopStorage.get(k("selected"))
    actual fun saveSelectedTheme(themeName: String) = DesktopStorage.put(k("selected"), themeName)
    actual fun loadAmoledEnabled(): Boolean? = DesktopStorage.getBoolean(k("amoled"))
    actual fun saveAmoledEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("amoled"), enabled)
    actual fun loadLiquidGlassNativeTabBarEnabled(): Boolean? = DesktopStorage.getBoolean(k("liquid_glass"))
    actual fun saveLiquidGlassNativeTabBarEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("liquid_glass"), enabled)
    actual fun loadSelectedAppLanguage(): String? = DesktopStorage.get(k("app_language"))
    actual fun saveSelectedAppLanguage(languageCode: String) = DesktopStorage.put(k("app_language"), languageCode)
    actual fun applySelectedAppLanguage(languageCode: String) { /* no-op on desktop */ }
    actual fun exportToSyncPayload(): JsonObject = buildJsonObject { }
    actual fun replaceFromSyncPayload(payload: JsonObject) { }
}
