package com.wedge.drawingtoyou.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wedge.drawingtoyou.core.navigation.navigator.WdtyNavigator

@Composable
fun WdtyNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    navigator: WdtyNavigator,
    selectedScreen: (route: String) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = WdtyScreens.Home.route
    ) {
        lyfeHomeNavigation(
            navigator = navigator,
            navHostController = navHostController,
            selectedScreen = selectedScreen
        )
    }
}