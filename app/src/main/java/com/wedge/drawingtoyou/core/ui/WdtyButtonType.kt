package com.wedge.drawingtoyou.core.ui

import androidx.compose.ui.graphics.Color
import com.wedge.drawingtoyou.ui.theme.Primary500
import com.wedge.drawingtoyou.ui.theme.Primary900
import com.wedge.drawingtoyou.ui.theme.Secondary500
import com.wedge.drawingtoyou.ui.theme.Secondary900
import com.wedge.drawingtoyou.ui.theme.Surface

enum class WdtyButtonType(
    val defaultColor: Color,
    val activeColor: Color,
    val disabledColor: Color,
    val loadingColor: Color
) {
    PRIMARY(
        defaultColor = Surface,
        activeColor = Primary900,
        disabledColor = Primary500,
        loadingColor = Primary900
    ),
    SECONDARY(
        defaultColor = Surface,
        activeColor = Secondary900,
        disabledColor = Secondary500,
        loadingColor = Secondary900
    );

    fun getButtonColor(buttonState: WdtyButtonState) = when(buttonState) {
        WdtyButtonState.DEFAULT -> defaultColor
        WdtyButtonState.ACTIVE -> activeColor
        WdtyButtonState.DISABLED -> disabledColor
        WdtyButtonState.LOADING -> loadingColor
    }
}