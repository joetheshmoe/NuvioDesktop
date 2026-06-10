package com.nuvio.app.features.player

import java.util.Locale

internal actual object DeviceLanguagePreferences {
    actual fun preferredLanguageCodes(): List<String> {
        val locale = Locale.getDefault()
        return listOfNotNull(locale.language, locale.country.takeIf { it.isNotEmpty() }?.let { "${locale.language}-$it" })
    }
}
