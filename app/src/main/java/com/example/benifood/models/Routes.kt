package com.example.benifood.models

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splashScreen")
    object SignIn : Routes("signIn")
    object SignUp : Routes("signUp")
}
