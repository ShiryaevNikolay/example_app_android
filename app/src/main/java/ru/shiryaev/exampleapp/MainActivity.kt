package ru.shiryaev.exampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.shiryaev.exampleapp.app.App
import ru.shiryaev.exampleapp.modules.employee_detail.ui.screen.EmployeeDetailScreen
import ru.shiryaev.exampleapp.modules.home.service.api.HomeApi
import ru.shiryaev.exampleapp.modules.home.service.repository.HomeRepository
import ru.shiryaev.exampleapp.modules.home.ui.screen.HomeScreen
import ru.shiryaev.exampleapp.modules.home.ui.viewModel.HomeScreenViewModel
import ru.shiryaev.exampleapp.modules.splash.ui.SplashScreen
import ru.shiryaev.exampleapp.modules.splash.ui.viewModel.SplashViewModel
import ru.shiryaev.exampleapp.ui.theme.ExampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        /*
                        Показывает Splash
                         */
                        composable("splash") {
                            SplashScreen(SplashViewModel {
                                navController.navigate("home")
                            })
                        }
                        /*
                        Открывает главный экран
                         */
                        composable("home") {
                            HomeScreen(
                                viewModel = HomeScreenViewModel(
                                    homeRepository = HomeRepository(
                                        homeApi = App.retrofit.create(HomeApi::class.java)
                                    )
                                )
                            ) {
                                navController.navigate("employee_detail")
                            }
                        }
                        /*
                        Детальный просмотр информации о сотруднике
                         */
                        composable("employee_detail") {
                            EmployeeDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleAppTheme {
        Greeting("Android")
    }
}