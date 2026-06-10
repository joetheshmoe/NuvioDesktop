package com.nuvio.app.core.auth

import com.nuvio.app.DesktopStorage

internal actual object AuthStorage {
    private const val KEY_ANONYMOUS_USER_ID = "auth_anonymous_user_id"

    actual fun loadAnonymousUserId(): String? = DesktopStorage.get(KEY_ANONYMOUS_USER_ID)

    actual fun saveAnonymousUserId(userId: String) = DesktopStorage.put(KEY_ANONYMOUS_USER_ID, userId)

    actual fun clearAnonymousUserId() = DesktopStorage.remove(KEY_ANONYMOUS_USER_ID)
}
