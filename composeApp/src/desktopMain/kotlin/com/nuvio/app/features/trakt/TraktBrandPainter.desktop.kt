package com.nuvio.app.features.trakt

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter

@Composable
actual fun traktBrandPainter(asset: TraktBrandAsset): Painter {
    return ColorPainter(Color.Gray)
}
