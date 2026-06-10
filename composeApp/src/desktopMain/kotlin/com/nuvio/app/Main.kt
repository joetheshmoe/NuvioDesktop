package com.nuvio.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.application
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val windowState = rememberWindowState(
        width = 1280.dp,
        height = 800.dp,
    )

    Window(
        onCloseRequest = ::exitApplication,
        title = "Nuvio",
        state = windowState,
    ) {
        App()
    }
}
