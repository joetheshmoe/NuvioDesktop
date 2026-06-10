package com.nuvio.app.core.ui

import coil3.ImageLoader

internal actual fun ImageLoader.Builder.configurePlatformImageLoader(): ImageLoader.Builder {
    // Desktop uses the default Coil components which work on JVM.
    return this
}
