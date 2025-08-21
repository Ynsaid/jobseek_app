package com.example.jopsearchapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jopsearchapp.ui.theme.Background
import com.example.jopsearchapp.ui.theme.Primary





@Composable
fun HomeScreen(navController: NavController) {
    val jobs = listOf(
        Job("Mid-level UX Designer", "Total", "Contractual", "Remote", "$64k - $80k/yearly", R.drawable.img1),
        Job("Design Lead", "GitLab", "Full Time", "Hybrid", "$70k - $95k/yearly", R.drawable.img2),
        Job("UX Researcher", "Paypal", "Part Time", "Remote", "$50k - $75k/yearly", R.drawable.img3),
        Job("Head of Product Design", "Uber", "Full Time", "On-Site", "$90k - $120k/yearly", R.drawable.img4),
        Job("Senior Product Designer", "Google INC", "Full Time", "On-Site", "$90k - $120k/yearly", R.drawable.img5),
        Job("Interaction Designer", "Dribbble", "Full Time", "On-Site", "$90k - $120k/yearly", R.drawable.img6)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔹 Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.me),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.notifications_icon),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(32.dp)
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${jobs.size} JOBS FOUND",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = Color.Black
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "All Relevance",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        color = Primary
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_drop_down_icon),
                        contentDescription = "Dropdown",
                        tint = Primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }




            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(jobs) { job ->
                    JobCard(
                        job = job,
                        onClick = { clickedJob ->
                            navController.currentBackStackEntry
                                ?.savedStateHandle
                                ?.set("job", clickedJob)

                            navController.navigate(Route.Details)
                        }
                    )

                }
            }
        }


        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    "Product Designer in Bronx NY",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(12.dp)),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            },
            trailingIcon = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "|",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Icon(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        painter = painterResource(id = R.drawable.filter_icon),
                        contentDescription = "Filter",
                        tint = Color.White
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Primary,
                unfocusedContainerColor = Primary,
                disabledContainerColor = Primary,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )
    }
}

@Composable
fun JobCard(
    job: Job,
    onClick: (Job) -> Unit
) {
    Box(
        modifier = Modifier
            .width(364.dp)
            .height(114.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { onClick(job) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = job.image),
                    contentDescription = "Company Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = job.title,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = Color(0xFF181A1F)
                    )
                    if (job.company.isNotEmpty()) {
                        Text(
                            text = job.company,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = Color(0xFF181A1F)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    if (job.fullTime.isNotEmpty()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(80.dp))
                                .background(Color(0xFFEAEAEA))
                                .padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = job.fullTime,
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = Color(0xFF181A1F)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    if (job.remote.isNotEmpty()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(80.dp))
                                .background(Color(0xFFEAEAEA))
                                .padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = job.remote,
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = Color(0xFF181A1F)
                            )
                        }
                    }
                }

                if (job.salary.isNotEmpty()) {
                    Text(
                        text = job.salary,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = Color(0xFF181A1F)
                    )
                }
            }
        }
    }
}
