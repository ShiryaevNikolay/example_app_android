package ru.shiryaev.exampleapp.modules.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.shiryaev.exampleapp.R
import ru.shiryaev.exampleapp.modules.splash.ui.viewModel.SplashViewModel
import ru.shiryaev.exampleapp.ui.theme.ExampleAppTheme

@Composable
fun SplashScreen(
    viewModel: SplashViewModel
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplash() {
    ExampleAppTheme {
        SplashScreen(SplashViewModel {})
    }
}