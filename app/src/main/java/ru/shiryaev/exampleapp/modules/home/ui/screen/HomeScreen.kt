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
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.shiryaev.exampleapp.R
import ru.shiryaev.exampleapp.modules.home.service.response.Employee
import ru.shiryaev.exampleapp.modules.home.ui.viewModel.HomeScreenViewModel
import ru.shiryaev.exampleapp.common.ui.IconButton
import ru.shiryaev.exampleapp.modules.home.service.data.Tabs

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    onClickEmployee: (Employee) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val titles = listOf(
        Tabs.Employees,
        Tabs.Projects,
        Tabs.About
    )
    val employees by viewModel.employees.collectAsState()

    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage

    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_surf),
                contentDescription = ""
            )
            IconButton(
                icon = R.drawable.ic_search
            ) {

            }
        }
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.Transparent,
            edgePadding = 20.dp,
            indicator = @Composable { tabPositions ->
                Box(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                ) {
                    Box(
                        Modifier
                            .width(24.dp)
                            .height(3.dp)
                            .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                            .background(Color.Blue)
                            .align(Alignment.Center)
                    )
                }
            },
            divider = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier.height(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = title.title.uppercase(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W800,
                            color = if (tabIndex == index) {
                                Color.Blue
                            } else {
                                Color.Gray
                            }
                        )
                    }
                }
            }
        }

        HorizontalPager(
            count = titles.size,
            state = pagerState
        ) { index ->
            when {
                titles[index] == Tabs.Employees -> {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(employees) { employee ->
                            EmployeeCard(employee) {
                                onClickEmployee(employee)
                            }
                        }
                    }
                }
                titles[index] == Tabs.Projects -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Проекты",
                            Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                titles[index] == Tabs.About -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "О приложении",
                            Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmployeeCard(
    employee: Employee,
    onClick: (Employee) -> Unit
) {
    Card(
        elevation  = 12.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            Modifier.clickable { onClick(employee) }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = employee.userInfo.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 28.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(12.dp))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_surf),
                        contentDescription = "",
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.background)
                            .padding(4.dp),
                    )
                    Spacer(Modifier.width(16.dp))
                    Column {
                        Text(
                            text = employee.position,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )
                        Spacer(Modifier.height(8.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            item {
                                Tag(employee.department)
                            }

                            items(employee.skills) { skill ->
                                Tag(skill)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Tag(
    title: String
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                Color.LightGray
            )
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.W400
        )
    }
}