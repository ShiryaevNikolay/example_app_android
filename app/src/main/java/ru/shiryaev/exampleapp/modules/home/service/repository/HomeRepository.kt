package ru.shiryaev.exampleapp.modules.home.service.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.shiryaev.exampleapp.modules.home.service.api.HomeApi
import ru.shiryaev.exampleapp.modules.home.service.response.Project

class HomeRepository(
    val homeApi: HomeApi
) {

//    suspend fun getProjects(): List<Project> {
//        return withContext(Dispatchers.IO) {
//            homeApi.getProjects()
//        }
//    }
}