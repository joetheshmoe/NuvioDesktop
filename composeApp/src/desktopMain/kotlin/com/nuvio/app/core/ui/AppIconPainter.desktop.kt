package com.nuvio.app.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
actual fun appIconPainter(icon: AppIconResource): Painter {
    return ColorPainter(Color.Gray)
}

@Composable
internal actual fun nuvioBottomNavigationBarInsets(): androidx.compose.foundation.layout.WindowInsets =
    androidx.compose.foundation.layout.WindowInsets(0, 0, 0, 0)

internal actual val nuvioPlatformExtraTopPadding: androidx.compose.ui.unit.Dp = 0.dp
internal actual val nuvioPlatformExtraBottomPadding: androidx.compose.ui.unit.Dp = 0.dp
internal actual val nuvioBottomNavigationExtraVerticalPadding: androidx.compose.ui.unit.Dp = 0.dp
