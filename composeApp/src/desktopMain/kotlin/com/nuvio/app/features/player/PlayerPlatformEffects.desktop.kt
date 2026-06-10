package com.nuvio.app.features.player

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntSize

@Composable
actual fun LockPlayerToLandscape() {
    // Desktop windows are resizable; no orientation locking needed.
}

@Composable
actual fun EnterImmersivePlayerMode(keepScreenAwake: Boolean) {
    // Desktop has no immersive mode. No-op.
}

@Composable
actual fun ManagePlayerPictureInPicture(
    isPlaying: Boolean,
    playerSize: IntSize,
) {
    // PiP not supported on desktop.
}

@Composable
actual fun rememberPlayerGestureController(): PlayerGestureController? = null
