package com.wedge.drawingtoyou.core.navigation.navigator

import androidx.navigation.NavOptions

// Navigation에 대한 행동을 정의한 class
sealed class NavigationCommand {
	object NavigateUp : NavigationCommand()

	data class NavigateToRoute(val route: String, val options: NavOptions? = null) : NavigationCommand()

	data class NavigateUpWithResult<T>(val key: String, val result: T, val route: String? = null) : NavigationCommand()

	data class PopUpToRoute(val route: String, val inclusive: Boolean) : NavigationCommand()
}