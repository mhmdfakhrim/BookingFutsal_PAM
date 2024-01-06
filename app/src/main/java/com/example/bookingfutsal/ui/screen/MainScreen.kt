package com.example.bookingfutsal.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookingfutsal.nav.Screens
import com.example.bookingfutsal.R
import com.example.bookingfutsal.util.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    sharedViewModel: SharedViewModel,
    navController: NavController,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = "Salvator Futsal",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Center
                    ),
                    color = Color.White
                )
            },
            actions = {
                IconButton(onClick = {
                    sharedViewModel.logout(navController)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_logout_24),
                        contentDescription = stringResource(id = R.string.logout),
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.DarkGray)
        )
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.lpg_futsal), contentDescription = null)

            Spacer(modifier = Modifier.height(70.dp))

            // Tombol lihat pesanan
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(route = Screens.GetDataScreen.route)
                }
            ) {
                Text(text = "Lihat Pesanan")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Pesan lapangan
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(route = Screens.AddDataScreen.route)
                }
            ) {
                Text(text = "Pesan Lapangan")
            }
        }
    }
}