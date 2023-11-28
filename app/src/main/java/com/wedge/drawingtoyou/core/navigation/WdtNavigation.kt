package com.wedge.drawingtoyou.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wedge.drawingtoyou.core.navigation.navigator.WdtyNavigator
import com.wedge.drawingtoyou.feature.home.HomeScreen

fun NavGraphBuilder.lyfeHomeNavigation(
    navigator: WdtyNavigator,
    navHostController: NavHostController,
    selectedScreen: (route: String) -> Unit
) {
    composable(route = WdtyScreens.Home.name) {
        HomeScreen(navigator = navigator)
        selectedScreen(WdtyScreens.Home.name)
    }
}