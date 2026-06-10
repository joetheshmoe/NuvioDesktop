package com.nuvio.app.features.watchprogress

import com.nuvio.app.DesktopStorage

internal actual object ResumePromptStorage {
    private const val KEY_WAS = "resume_was_in_player"
    private const val KEY_VIDEO_ID = "resume_last_video_id"

    actual fun loadWasInPlayer(): Boolean = DesktopStorage.getBoolean(KEY_WAS) ?: false
    actual fun saveWasInPlayer(value: Boolean) = DesktopStorage.putBoolean(KEY_WAS, value)
    actual fun loadLastPlayerVideoId(): String? = DesktopStorage.get(KEY_VIDEO_ID)
    actual fun saveLastPlayerVideoId(videoId: String?) {
        if (videoId != null) DesktopStorage.put(KEY_VIDEO_ID, videoId)
        else DesktopStorage.remove(KEY_VIDEO_ID)
    }
}
