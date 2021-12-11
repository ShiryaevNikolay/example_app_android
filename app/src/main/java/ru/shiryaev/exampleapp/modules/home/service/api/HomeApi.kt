package ru.shiryaev.exampleapp.modules.home.service.api

import retrofit2.http.GET

interface HomeApi {

    @GET("http://demo4547913.mockable.io/projects-with-employees")
    suspend fun getProjects()
}