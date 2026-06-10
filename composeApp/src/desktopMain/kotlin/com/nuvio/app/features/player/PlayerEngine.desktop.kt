package com.nuvio.app.features.player

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Stub desktop media player controller.
 * Replace with VLCJ/MPV/GStreamer integration for actual playback.
 */
class StubPlayerEngineController : PlayerEngineController {
    override fun play() { }
    override fun pause() { }
    override fun seekTo(positionMs: Long) { }
    override fun seekBy(offsetMs: Long) { }
    override fun retry() { }
    override fun setPlaybackSpeed(speed: Float) { }
    override fun setMuted(muted: Boolean) { }
    override fun getAudioTracks(): List<AudioTrack> = emptyList()
    override fun getSubtitleTracks(): List<SubtitleTrack> = emptyList()
    override fun selectAudioTrack(index: Int) { }
    override fun selectSubtitleTrack(index: Int) { }
    override fun setSubtitleUri(url: String) { }
    override fun clearExternalSubtitle() { }
    override fun clearExternalSubtitleAndSelect(trackIndex: Int) { }
}

@Composable
actual fun PlatformPlayerSurface(
    sourceUrl: String,
    sourceAudioUrl: String?,
    sourceHeaders: Map<String, String>,
    sourceResponseHeaders: Map<String, String>,
    useYoutubeChunkedPlayback: Boolean,
    modifier: Modifier,
    playWhenReady: Boolean,
    resizeMode: PlayerResizeMode,
    useNativeController: Boolean,
    onControllerReady: (PlayerEngineController) -> Unit,
    onSnapshot: (PlayerPlaybackSnapshot) -> Unit,
    onError: (String?) -> Unit,
) {
    LaunchedEffect(sourceUrl) {
        onControllerReady(StubPlayerEngineController())
        onError("Desktop video player: install libvlc (vlcj) for playback. Using stub.")
        onSnapshot(PlayerPlaybackSnapshot(
            positionMs = 0,
            durationMs = 0,
            isPlaying = false,
        ))
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Video player not yet available.\nInstall VLC (libvlc) for playback support.",
            color = Color.Gray,
        )
    }
}
