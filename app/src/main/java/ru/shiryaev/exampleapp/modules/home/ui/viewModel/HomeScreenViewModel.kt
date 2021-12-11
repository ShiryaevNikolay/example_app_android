package ru.shiryaev.exampleapp.modules.home.ui.viewModel

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.shiryaev.exampleapp.modules.home.service.repository.HomeRepository
import ru.shiryaev.exampleapp.modules.home.service.response.Employee
import ru.shiryaev.exampleapp.modules.home.service.response.Project
import ru.shiryaev.exampleapp.modules.home.service.response.UserInfo
import java.util.concurrent.TimeUnit

class HomeScreenViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    val employees = MutableStateFlow(mockPeople)
    val errorState = MutableStateFlow(false)
    val loadingState = MutableStateFlow(true)

    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val handler = CoroutineExceptionHandler { context, exceprion ->

    }

    fun getProjects() {
        scope.launch(handler) {
//            val projects = homeRepository.getProjects()
            TimeUnit.MILLISECONDS.sleep(2000)
//            projectsState.emit(projects)
            loadingState.emit(false)
        }
    }

    companion object {
        private val mockPeople = listOf(
            Employee(
                id = "398793017",
                userInfo = UserInfo(
                    name = "Ольга Кудрявцева",
                    age = 19,
                    city = "Voronezh",
                    phone = "+7 (000) 000 00 00",
                ),
                position = "Android developer",
                skills = listOf(
                    "mvvm",
                    "compose",
                    "coroutines",
                    "jetpack"
                ),
                createdDate = 1566038241,
                department = "android",
                photoUrl = "https://jrnlst.ru/sites/default/files/cover/cover_6.jpg",
                currentProject = "Zenit",
                experience = "36",
            ),
            Employee(
                id = "4234234234",
                userInfo = UserInfo(
                    name = "Игорь Крутой",
                    age = 21,
                    city = "New York",
                    phone = "+7 (000) 000 00 00",
                ),
                position = "Business Analyst",
                skills = listOf(
                    "swagger",
                    "api",
                    "UI/UX",
                ),
                createdDate = 1566038241,
                department = "BA",
                photoUrl = "https://jrnlst.ru/sites/default/files/cover/cover_6.jpg",
                currentProject = "Bethowen",
                experience = "12",
            ),
            Employee(
                id = "988909482",
                userInfo = UserInfo(
                    name = "Алеся Патрикеевна",
                    age = 28,
                    city = "Paris",
                    phone = "+7 (000) 000 00 00",
                ),
                position = "iOS developer",
                skills = listOf(
                    "MVP",
                    "Swift UI",
                    "coroutines",
                ),
                createdDate = 1566038241,
                department = "iOS",
                photoUrl = "https://jrnlst.ru/sites/default/files/cover/cover_6.jpg",
                currentProject = "Burger King",
                experience = "19",
            )
        )
    }
}