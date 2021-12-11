package ru.shiryaev.exampleapp.modules.splash.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class SplashViewModel(
    val goNextScreen: () -> Unit
) : ViewModel() {

    private val scope = CoroutineScope(Job())

    init {
        scope.launch {
            TimeUnit.MILLISECONDS.sleep(2000)
            withContext(Dispatchers.Main) {
                goNextScreen()
            }
        }
    }
}