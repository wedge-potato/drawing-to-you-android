package com.wedge.drawingtoyou.feature.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wedge.drawingtoyou.core.navigation.navigator.WdtyNavigator
import com.wedge.drawingtoyou.core.navigation.navigator.WdtyNavigatorImpl

@Composable
fun LandingScreen(
    navigator: WdtyNavigator
) {


}

@Preview
@Composable
private fun Preview_LandingScreen() {
    LandingScreen(navigator = WdtyNavigatorImpl())
}