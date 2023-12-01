package com.example.benifood.ui.signin.data.network

import android.util.Log
import com.example.benifood.ui.signin.data.network.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInService @Inject constructor(
    private val client: SignInClient
) {

    suspend fun doSignIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.doSignIn(UserDTO(user, password))

            Log.i("DAM", response.body()?.accessToken!!)

            !response.body()?.accessToken.isNullOrEmpty()
        }
    }
}