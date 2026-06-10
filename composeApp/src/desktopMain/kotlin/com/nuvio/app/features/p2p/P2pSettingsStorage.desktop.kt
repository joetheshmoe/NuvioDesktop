package com.nuvio.app.features.p2p

import com.nuvio.app.DesktopStorage

internal actual object P2pSettingsStorage {
    private fun k(p: String) = "p2p_$p"
    actual fun loadP2pEnabled(): Boolean? = DesktopStorage.getBoolean(k("enabled"))
    actual fun saveP2pEnabled(enabled: Boolean) = DesktopStorage.putBoolean(k("enabled"), enabled)
    actual fun loadEnableUpload(): Boolean? = DesktopStorage.getBoolean(k("upload"))
    actual fun saveEnableUpload(enabled: Boolean) = DesktopStorage.putBoolean(k("upload"), enabled)
    actual fun loadHideTorrentStats(): Boolean? = DesktopStorage.getBoolean(k("hide_stats"))
    actual fun saveHideTorrentStats(enabled: Boolean) = DesktopStorage.putBoolean(k("hide_stats"), enabled)
}
