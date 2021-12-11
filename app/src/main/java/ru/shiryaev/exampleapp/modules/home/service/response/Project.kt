package ru.shiryaev.exampleapp.modules.home.service.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Project(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("descriptions")
    val descriptions: String,
    @SerializedName("team")
    val team: Team,
) : Serializable

data class Team(
    @SerializedName("employees")
    val employees: List<Employee>
)