package ru.shiryaev.exampleapp.modules.employee_detail.ui.view_model

import androidx.lifecycle.ViewModel
import ru.shiryaev.exampleapp.modules.home.service.response.Employee
import ru.shiryaev.exampleapp.modules.home.service.response.UserInfo

class EmployeeDetailViewModel : ViewModel() {

    private val employee = Employee(
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
    )

    fun getEmployee(): Employee = employee
}