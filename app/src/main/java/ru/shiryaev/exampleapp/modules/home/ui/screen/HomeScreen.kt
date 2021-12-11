package ru.shiryaev.exampleapp.modules.home.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Text(text = "Home")
}

@Preview()
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}