package ru.shiryaev.exampleapp.modules.home.service.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Employee(
    @SerializedName("id")
    val id: String,
    @SerializedName("userInfo")
    val userInfo: UserInfo,
    @SerializedName("position")
    val position: String,
    @SerializedName("skills")
    val skills: List<String>,
    @SerializedName("createdDate")
    val createdDate: Int,
    @SerializedName("department")
    val department: String,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("currentProject")
    val currentProject: String,
    @SerializedName("experience")
    val experience: String
) : Serializable

data class UserInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("phone")
    val phone: String
) : Serializable