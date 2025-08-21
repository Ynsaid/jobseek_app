package com.example.jopsearchapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jopsearchapp.R
import com.example.jopsearchapp.ui.theme.Primary


@Composable
fun SplashScreen(navController : NavHostController) {
    /* ---------------- logic -----------------
    * 1:: head
    * 2:: text and all re.. btn
    * 3:: job card
    * 4:: search bar with filter
    * 5:: make effect to go to next screen
    * */

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
           painter = painterResource(id = R.drawable.person3d),
            contentDescription = "image",
            modifier = Modifier.fillMaxSize(0.5f)
        )
        Text(
            text = "Climb higher with\n" +
                    "JobSeek app",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            lineHeight = 38.sp,
            textAlign = TextAlign.Center,
            color = White
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp),
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(
              containerColor = White ,
                contentColor = Primary
            ),
            shape =  RoundedCornerShape(12.dp)
        ){
            Text(text = "Start browsing", fontSize = 18.sp , fontFamily = FontFamily(Font(R.font.poppins_bold)), color = Primary)

        }
    }

}

