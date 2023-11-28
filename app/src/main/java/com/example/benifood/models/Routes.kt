package com.example.benifood.models

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash")
    object SignIn : Routes("signIn")
    object SignUp : Routes("signUp")
    object Home : Routes("home")
}
