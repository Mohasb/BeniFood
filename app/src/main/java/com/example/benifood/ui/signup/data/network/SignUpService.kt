package com.example.benifood.ui.signup.data.network

import android.util.Log
import com.example.benifood.ui.signup.data.network.dto.UserRegisterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpService @Inject constructor(
    private val client: SignUpClient
) {
    suspend fun doSignUp(name: String, user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.doSignUp(UserRegisterDTO(name, user, password))

            Log.i("DAM aasd", response.body()?.email!!)

            !response.body()?.email.isNullOrEmpty()
        }
    }
}