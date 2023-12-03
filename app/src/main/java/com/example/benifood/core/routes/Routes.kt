package com.example.benifood.core.routes

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash")
    object SignIn : Routes("signIn")
    object SignUp : Routes("signUp")
    object Home : Routes("home")
    object Details : Routes("details")
}
