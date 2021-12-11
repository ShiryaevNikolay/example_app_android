package ru.shiryaev.exampleapp.modules.home.service.api

import retrofit2.http.GET
import ru.shiryaev.exampleapp.modules.home.service.response.Project

interface HomeApi {

    @GET("projects-with-employees")
    suspend fun getProjects(): List<Project>
}