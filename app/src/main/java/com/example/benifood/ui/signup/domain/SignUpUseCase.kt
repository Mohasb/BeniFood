package com.example.benifood.ui.signup.domain

import com.example.benifood.ui.signup.data.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val networkRepository: SignUpRepository
) {
    suspend operator fun invoke(name: String, user: String, password: String): Boolean =
        networkRepository.doSignUp(name, user, password)
}