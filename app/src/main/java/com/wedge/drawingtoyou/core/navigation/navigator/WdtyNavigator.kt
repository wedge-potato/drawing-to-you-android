package com.wedge.drawingtoyou.core.navigation.navigator

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onSubscription

abstract class WdtyNavigator : Navigator() {

    // 일반적인 navigate
    abstract fun navigate(route: String, optionBuilder: (NavOptionsBuilder.() -> Unit)? = null)

    // 결과값을 가지고 돌아가야하는 경우
    abstract fun <T> navigateBackWithResult(key: String, result: T, route: String?)

    // 일반적인 popup
    abstract fun popUpTo(route: String, inclusive: Boolean)

    // Single Instance 형태로 동작
    abstract fun navigateAndroidClearBackStack(route: String)

    suspend fun handleNavigationCommands(navController: NavController) {
        navigationCommands
            .onSubscription { this@WdtyNavigator.navControllerFlow.value = navController }
            .onCompletion { this@WdtyNavigator.navControllerFlow.value = null }
            .collect { navController.handleLyfeNavigationCommand(it) }
    }

    private fun NavController.handleLyfeNavigationCommand(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.NavigateToRoute -> {
                navigate(navigationCommand.route, navigationCommand.options)
            }

            is NavigationCommand.NavigateUp -> {
                navigateUp()
            }

            is NavigationCommand.PopUpToRoute -> popBackStack(
                navigationCommand.route,
                navigationCommand.inclusive
            )

            is NavigationCommand.NavigateUpWithResult<*> -> {
                navUpWithResult(navigationCommand)
            }
        }
    }

    private fun NavController.navUpWithResult(
        navigationCommand: NavigationCommand.NavigateUpWithResult<*>
    ) {
        val backStackEntry =
            navigationCommand.route?.let { getBackStackEntry(it) }
                ?: previousBackStackEntry
        backStackEntry?.savedStateHandle?.set(
            navigationCommand.key,
            navigationCommand.result
        )

        navigationCommand.route?.let {
            popBackStack(it, false)
        } ?: run {
            navigateUp()
        }
    }
}