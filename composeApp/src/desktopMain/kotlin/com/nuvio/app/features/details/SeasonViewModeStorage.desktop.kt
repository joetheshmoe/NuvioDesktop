package com.nuvio.app.features.details

import com.nuvio.app.DesktopStorage

internal actual object SeasonViewModeStorage {
    private const val KEY = "season_view_mode"

    actual fun load(): SeasonViewMode? {
        val raw = DesktopStorage.get(KEY) ?: return null
        return try { SeasonViewMode.valueOf(raw) } catch (_: Exception) { null }
    }

    actual fun save(mode: SeasonViewMode) {
        DesktopStorage.put(KEY, mode.name)
    }
}
