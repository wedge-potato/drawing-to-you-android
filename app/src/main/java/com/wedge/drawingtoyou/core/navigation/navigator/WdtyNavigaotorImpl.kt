package com.wedge.drawingtoyou.core.navigation.navigator

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import javax.inject.Inject

class WdtyNavigatorImpl @Inject constructor() : WdtyNavigator() {

    override fun navigate(route: String, optionBuilder: (NavOptionsBuilder.() -> Unit)?) {
        val options = optionBuilder?.let { navOptions(it) }
        navigationCommands.tryEmit(NavigationCommand.NavigateToRoute(route = route, options = options))
    }

    override fun <T> navigateBackWithResult(key: String, result: T, route: String?) {
        navigationCommands.tryEmit(
            NavigationCommand.NavigateUpWithResult(
                key = key,
                result = result,
                route = route
            )
        )
    }

    override fun popUpTo(route: String, inclusive: Boolean) {
        navigationCommands.tryEmit(NavigationCommand.PopUpToRoute(route, inclusive))
    }

    override fun navigateAndroidClearBackStack(route: String) {
        navigationCommands.tryEmit(
            NavigationCommand.NavigateToRoute(
                route = route,
                options = navOptions {
                    popUpTo(0)
                }
            )
        )
    }
}