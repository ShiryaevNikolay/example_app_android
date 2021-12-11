package ru.shiryaev.exampleapp.modules.employee_detail.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.shiryaev.exampleapp.R
import ru.shiryaev.exampleapp.common.ui.IconButton
import ru.shiryaev.exampleapp.modules.employee_detail.ui.view_model.EmployeeDetailViewModel
import ru.shiryaev.exampleapp.modules.home.service.response.Employee

@Composable
fun EmployeeDetailScreen(
    viewModel: EmployeeDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onBackPressed: () -> Unit
) {
    val employee = remember { viewModel.getEmployee() }

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    icon = R.drawable.ic_arrow_right
                ) {
                    onBackPressed()
                }

                IconButton(
                    icon = R.drawable.ic_call
                ) {

                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 40.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_surf),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(112.dp)
                        .background(Color.LightGray)
                        .padding(10.dp)
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    text = employee.userInfo.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W400
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = employee.userInfo.phone,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Blue
                )
                Spacer(Modifier.height(18.dp))
                Text(
                    text = employee.userInfo.city,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
            }
            InfoCard(employee)
        }
    }
}

@Composable
fun InfoCard(
    employee: Employee
) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            )
            .shadow(
                elevation = 20.dp
            )
            .background(Color.White)
            .padding(horizontal = 20.dp)
            .padding(top = 32.dp)
    ) {
        Column {
            Text(
                text = "О сотруднике",
                fontSize = 24.sp,
                fontWeight = FontWeight.W700
            )
            Spacer(Modifier.height(20.dp))
            InfoRow(
                title = "Должность",
                subtitle = employee.position
            )
            Spacer(Modifier.height(12.dp))
            InfoRow(
                title = "Опыт работы",
                subtitle = "${employee.experience} мес."
            )
            Spacer(Modifier.height(12.dp))
            InfoRow(
                title = "Отдел",
                subtitle = employee.department,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun InfoRow(
    title: String,
    subtitle: String,
    color: Color? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400
        )
        Text(
            text = subtitle,
            fontSize = 17.sp,
            fontWeight = FontWeight.W700,
            color = color ?: Color.Black
        )
    }
}