package com.nuvio.app

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Desktop Linux (${System.getProperty("os.name")})"
}

internal actual val isIos: Boolean = false
