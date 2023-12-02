package com.example.benifood.ui.signup.data

import com.example.benifood.ui.signup.data.network.SignUpService
import javax.inject.Inject

class SignUpRepository @Inject constructor(private val api: SignUpService) {

    suspend fun doSignUp(name: String, user: String, password: String): Boolean =
        api.doSignUp(name, user, password)

}