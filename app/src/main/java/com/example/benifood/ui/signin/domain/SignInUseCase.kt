package com.example.benifood.ui.signin.domain


import com.example.benifood.core.security.PasswordHash
import com.example.benifood.ui.signin.data.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val networkRepository: SignInRepository,
    private val cryptoHash: PasswordHash
) {

    suspend operator fun invoke(user: String, password: String):Boolean =
        networkRepository.doSignIn(user, password)
}