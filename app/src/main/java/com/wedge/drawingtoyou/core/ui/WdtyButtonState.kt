package com.wedge.drawingtoyou.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.wedge.drawingtoyou.R
import com.wedge.drawingtoyou.ui.theme.OnPrimaryActive
import com.wedge.drawingtoyou.ui.theme.OnPrimaryDisabled
import com.wedge.drawingtoyou.ui.theme.OnSurfaceMuted

enum class WdtyButtonState(
    @DrawableRes val brushIcon: Int,
    val textColor: Color,
) {

    DEFAULT(
        brushIcon = R.drawable.ic_brush_surface_muted,
        textColor = OnSurfaceMuted
    ),
    ACTIVE(
        brushIcon = R.drawable.ic_brush_surface_active,
        textColor = OnPrimaryActive
    ),
    DISABLED(
        brushIcon = R.drawable.ic_brush_surface_disabled,
        textColor = OnPrimaryDisabled
    ),
    LOADING(
        brushIcon = R.drawable.ic_brush_surface_muted,
        textColor = OnPrimaryActive
    )
}