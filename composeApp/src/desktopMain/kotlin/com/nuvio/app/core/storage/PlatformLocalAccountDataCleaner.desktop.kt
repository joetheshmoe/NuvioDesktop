package com.nuvio.app.core.storage

import com.nuvio.app.DesktopStorage

internal actual object PlatformLocalAccountDataCleaner {
    actual fun wipe() {
        DesktopStorage.clearAll()
    }
}
