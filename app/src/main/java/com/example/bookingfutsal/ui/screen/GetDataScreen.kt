package com.example.bookingfutsal.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookingfutsal.util.SharedViewModel
import com.example.bookingfutsal.util.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    var userID: String by remember { mutableStateOf("") }
    var nama: String by remember { mutableStateOf("") }
    var alamat: String by remember { mutableStateOf("") }
    var telpon: String by remember { mutableStateOf("") }
    var telponInt: Int by remember { mutableStateOf(0) }
    var tanggal: String by remember { mutableStateOf("") }
    var jambermain: String by remember { mutableStateOf("") }
    var jambermainInt: Int by remember { mutableStateOf(0) }
    var lapangan: String by remember { mutableStateOf("") }
    var lapanganInt: Int by remember { mutableStateOf(0) }
    var jammasuk: String by remember { mutableStateOf("") }


    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        // back button
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = "Cek Pemesanan",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.DarkGray)
        )
        // get data Layout
        Column(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // userID
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    value = userID,
                    onValueChange = {
                        userID = it
                    },
                    label = {
                        Text(text = "Nomor pemesanan anda")
                    }
                )
                // get user data Button
                Button(
                    modifier = Modifier
                        .padding(start = 2.dp)
                        .width(200.dp),
                    onClick = {
                        sharedViewModel.retrieveData(
                            userID = userID,
                            context = context
                        ) { data ->
                            nama = data.nama
                            alamat = data.alamat
                            telpon = data.telpon.toString()
                            telponInt = telpon.toInt()
                            tanggal = data.tanggal
                            lapangan = data.lapangan.toString()
                            lapanganInt = lapangan.toInt()
                            jambermain = data.jambermain.toString()
                            jambermainInt = jambermain.toInt()

                        }
                    }
                ) {
                    Text(text = "Cek")
                }
            }
            // Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nama,
                onValueChange = {
                    nama = it
                },
                label = {
                    Text(text = "Nama")
                }
            )
            // Profession
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = alamat,
                onValueChange = {
                    alamat = it
                },
                label = {
                    Text(text = "Alamat")
                }
            )
            // telpon
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = telpon,
                onValueChange = {
                    telpon = it
                    if (telpon.isNotEmpty()) {
                        telponInt = telpon.toInt()
                    }
                },
                label = {
                    Text(text = "Telpon")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // tanggal
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tanggal,
                onValueChange = {
                    tanggal = it
                },
                label = {
                    Text(text = "Tanggal")
                }
            )
            // lapangan
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = lapangan,
                onValueChange = {
                    lapangan = it
                    if (lapangan.isNotEmpty()) {
                        lapanganInt = lapangan.toInt()
                    }
                },
                label = {
                    Text(text = "Lapangan")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // jam
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = jam,
                onValueChange = {
                    jam = it
                    if (jam.isNotEmpty()) {
                        jamInt = jam.toInt()
                    }
                },
                label = {
                    Text(text = "Jam")
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
                        telpon = telponInt,
                        tanggal = tanggal,
                        lapangan = lapanganInt,
                        jambermain = jambermainInt

                    )

                    sharedViewModel.saveData(userData = userData, context = context)
                }
            ) {
                Text(text = "Ganti pesanan")
            }
            // delete Button
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                    sharedViewModel.deleteData(
                        userID = userID,
                        context = context,
                        navController = navController
                    )
                }
            ) {
                Text(text = "Batalkan pesanan")
            }
        }
    }
}