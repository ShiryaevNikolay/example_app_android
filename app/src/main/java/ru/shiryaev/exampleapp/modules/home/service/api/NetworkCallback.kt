package ru.shiryaev.exampleapp.modules.home.service.api

import ru.shiryaev.exampleapp.modules.home.service.response.Project

interface NetworkCallback {
    fun onSuccess(projects: List<Project>)
    fun onError(error: Throwable)
}