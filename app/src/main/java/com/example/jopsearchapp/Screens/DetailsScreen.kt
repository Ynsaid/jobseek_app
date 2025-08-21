import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jopsearchapp.Job
import com.example.jopsearchapp.R
import com.example.jopsearchapp.ui.theme.Background
import com.example.jopsearchapp.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController,job: Job) {
    Scaffold(
        floatingActionButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /* TODO: Apply action */ },
                    modifier = Modifier
                        .width(250.dp)
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary,
                        contentColor = Color.White
                    )
                ) {
                    Text("APPLY NOW")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center, // ✅ Center FAB
        containerColor = Background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            // ===== Top Card (Back + Save, Logo, Title) =====
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back" , modifier = Modifier.clickable { navController.popBackStack() })
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Save")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF0A66C2)),
                        contentAlignment = Alignment.Center
                    ) {
                       Image(
                           painter = painterResource(id = job.image),
                           contentDescription = "Company Logo",
                           Modifier.fillMaxSize()
                       )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = job.title,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(job.company, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    Text("Posted on 20 July", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ===== Job Info Card =====
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.weight(1f) // ✅ Equal space
                        ) {
                            Text("APPLY BEFORE", fontSize = 12.sp,  fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F))
                            Text("30 July, 2021",  fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F))
                        }
                        Column(
                            modifier = Modifier.weight(1f) // ✅ Equal space
                        ) {
                            Text("JOB NATURE", fontSize = 12.sp,  fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F))
                            Text(job.fullTime, fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F))
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Left column (Salary)
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "SALARY RANGE",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F)
                            )
                            Text(
                                text = "$100k - $120k/yearly",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F)
                            )
                        }

                        // Right column (Location)
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "JOB LOCATION",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F)
                            )
                            Text(
                                text = "Work from anywhere",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color(0xFF181A1F)
                            )
                        }
                    }

                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            // ===== Job Description Card =====
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {
                    Text("JOB DESCRIPTION", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Can you bring creative human-centered ideas to life and make great things happen beyond what meets the eye? " +
                                "We believe in teamwork, fun, complex projects, diverse perspectives, and simple solutions. " +
                                "How about you? We're looking for a like-minded...",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("See more", color = Primary, fontWeight = FontWeight.SemiBold)
                        Icon(painterResource(R.drawable.arrow_drop_down_icon), contentDescription = "Expand" , tint = Primary)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ===== Roles & Responsibilities Card =====
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {
                    Text("ROLES AND RESPONSIBILITIES", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("- Someone who has ample work experience with synthesizing primary research, developing insights, and strategies.")
                    Text("- Adapt and meticulous with creating user journeys and flows.")
                    Text("- Collaborate with cross-functional teams to deliver impactful designs.")
                }
            }

            Spacer(modifier = Modifier.height(80.dp)) // space for floating button
        }
    }
}
