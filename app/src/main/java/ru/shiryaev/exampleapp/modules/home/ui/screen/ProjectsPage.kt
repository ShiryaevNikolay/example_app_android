package ru.shiryaev.exampleapp.modules.home.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.shiryaev.exampleapp.R
import ru.shiryaev.exampleapp.modules.home.service.response.Employee
import ru.shiryaev.exampleapp.modules.home.service.response.Project
import ru.shiryaev.exampleapp.modules.home.service.response.Team
import ru.shiryaev.exampleapp.modules.home.service.response.UserInfo

@Composable
fun ProjectsPage() {
    val projects = listOf(
        Project(
            id = "398793017",
            name = "Zenit Bank",
            descriptions = "",
            team = Team(
                employees = listOf(
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
                    ),
                )
            )
        )
    )
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(projects) { project ->
            ProjectCard(project) {}
        }
    }
}

@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit
) {
    Card(
        elevation  = 12.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            Modifier.clickable { onClick() }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 4.dp,
                                    topEnd = 12.dp,
                                    bottomStart = 12.dp,
                                    bottomEnd = 12.dp,
                                )
                            )
                            .background(Color.Magenta)
                    ) {
                        Text(
                            text = "N",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_surf),
                        contentDescription = "",
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.background)
                            .padding(4.dp),
                    )
                }
                Spacer(Modifier.height(18.dp))
                Text(
                    text = "${project.team.employees.size} участника",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W400
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "${project.name}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W700
                )
            }
        }
    }
}