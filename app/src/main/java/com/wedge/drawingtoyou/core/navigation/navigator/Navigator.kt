package com.wedge.drawingtoyou.core.navigation.navigator

import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

open class Navigator {
	val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

	// 첫 컴포지션 전에 ViewModel이 관찰할 수 있도록 사용되는 변수
	val navControllerFlow = MutableStateFlow<NavController?>(null)

	fun navigateUp() {
		navigationCommands.tryEmit(NavigationCommand.NavigateUp)
	}
}