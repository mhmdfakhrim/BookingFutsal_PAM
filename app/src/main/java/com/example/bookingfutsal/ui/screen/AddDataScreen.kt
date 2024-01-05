package com.example.bookingfutsal.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookingfutsal.util.SharedViewModel
import com.example.bookingfutsal.util.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    var userID: String by remember { mutableStateOf("") }
    var nama: String by remember { mutableStateOf("") }
    var alamat: String by remember { mutableStateOf("") }
    var telpon: String by remember { mutableStateOf("") }
    var telponInt: Int by remember { mutableStateOf(0) }
    var tanggal: String by remember { mutableStateOf("") }
    var jam: String by remember { mutableStateOf("") }
    var jamInt: Int by remember { mutableStateOf(0) }
    var lapangan: String by remember { mutableStateOf("") }
    var lapanganInt: Int by remember { mutableStateOf(0) }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        // back button
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }
        // add data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // userID
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = userID,
                onValueChange = {
                    userID = it
                },
                label = {
                    Text(text = "Masukkan nomor pemesanan anda, mohon diingat")
                }
            )
            // Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nama,
                onValueChange = {
                    nama = it
                },
                label = {
                    Text(text = "Masukkan nama anda")
                }
            )
            // alamat
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = alamat,
                onValueChange = {
                    alamat = it
                },
                label = {
                    Text(text = "Masukkan Alamat Anda")
                }
            )
            // Telpon
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = telpon,
                onValueChange = {
                                telpon = it
                    if (telpon.isNotEmpty()){
                        telponInt = telpon.toInt()
                    }
                },
                label = {
                    Text(text = "Masukkan nomor telpon anda")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // Tanggal
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tanggal,
                onValueChange = {
                    tanggal = it
                },
                label = {
                    Text(text = "Masukkan tanggal yang anda inginkan")
                }
            )
            // Lapangan
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = lapangan,
                onValueChange = {
                    lapangan = it
                    if (lapangan.isNotEmpty()){
                        lapanganInt = lapangan.toInt()
                    }
                },
                label = {
                    Text(text = "Pilih Lapangan 1,2 atau 3")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // jam
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = jam,
                onValueChange = {
                    jam = it
                    if (jam.isNotEmpty()){
                        jamInt = jam.toInt()
                    }
                },
                label = {
                    Text(text = "Masukkan berapa jam anda ingin bermain")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val userData = UserData(
                        userID = userID,
                        nama = nama,
                        alamat = alamat,
                        telpon = telponInt
                    )

                    sharedViewModel.saveData(userData = userData, context = context)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}