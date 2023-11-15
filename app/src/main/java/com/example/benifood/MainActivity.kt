package com.example.benifood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.benifood.models.Routes.*
import com.example.benifood.ui.signin.ui.SignInScreen
import com.example.benifood.ui.signin.ui.SignInViewModel
import com.example.benifood.ui.signup.ui.SignUpScreen
import com.example.benifood.ui.signup.ui.SignUpViewModel
import com.example.benifood.ui.splashscreen.ui.SplashScreen
import com.example.benifood.ui.theme.BeniFoodTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signInViewModel: SignInViewModel by viewModels()
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeniFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = SplashScreen.route) {
                        composable(SplashScreen.route) {SplashScreen(navController)}
                        composable(SignIn.route) {SignInScreen(signInViewModel, navController)}
                        composable(SignUp.route) {SignUpScreen(signUpViewModel, navController)}
                    }
                }
            }
        }
    }
}


