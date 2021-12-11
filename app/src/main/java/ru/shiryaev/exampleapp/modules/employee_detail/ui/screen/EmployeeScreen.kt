package ru.shiryaev.exampleapp.modules.employee_detail.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.shiryaev.exampleapp.R
import ru.shiryaev.exampleapp.common.ui.IconButton
import ru.shiryaev.exampleapp.modules.employee_detail.ui.view_model.EmployeeDetailViewModel

@Composable
fun EmployeeDetailScreen(
    viewModel: EmployeeDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
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
            Surface(
                color = Color.White,
                modifier = Modifier.fillMaxHeight()
            ) {

            }
        }
    }
}