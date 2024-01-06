package com.example.bookingfutsal.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookingfutsal.nav.Screens
import com.example.bookingfutsal.R

@Composable
fun MainScreen(
    navController: NavController,
){
    Column(
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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