package com.example.bookingfutsal.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookingfutsal.util.FbViewModel
import com.example.bookingfutsal.main.NotificationMessage
import com.example.bookingfutsal.ui.screen.AddDataScreen
import com.example.bookingfutsal.ui.screen.GetDataScreen
import com.example.bookingfutsal.ui.screen.LoginScreen
import com.example.bookingfutsal.ui.screen.MainScreen
import com.example.bookingfutsal.ui.screen.SignupScreen
import com.example.bookingfutsal.util.SharedViewModel
import com.example.bookingfutsal.util.UserData

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    sharedViewModel: SharedViewModel
) {

    val vm = hiltViewModel<FbViewModel>()
    
    NotificationMessage(vm)

    val uiState by sharedViewModel.stateUI.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController, vm)

        }
        composable(route = Screens.SignupScreen.route) {
            SignupScreen(navController, vm)

        }
        // main screen
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(navController = navController, sharedViewModel = SharedViewModel())
        }
        // get data screen
        composable(
            route = Screens.GetDataScreen.route
        ) {
            GetDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel,
                dataHarga = UserData()
            )
        }
        // add data screen
        composable(
            route = Screens.AddDataScreen.route
        ) {
            AddDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel,
                onConfirmButtonClicked = { sharedViewModel.setJumlah(it) }
            )
        }
    }
}