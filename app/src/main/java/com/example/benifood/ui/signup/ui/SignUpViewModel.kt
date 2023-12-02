package com.example.benifood.ui.signup.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.benifood.core.routes.Routes
import com.example.benifood.ui.signup.domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase) : ViewModel() {

    //TODO:Delete the initial values below. It's just to test and so you don't have to enter the email and password every time
    private val _name = MutableLiveData<String>("Muhammad")
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>("abc123@gmail.com")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>("Abc123@gmail.com")
    val password: LiveData<String> = _password

    private val _sigUpEnabled = MutableLiveData<Boolean>()
    val sigUpEnabled: LiveData<Boolean> = _sigUpEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _showToast = MutableLiveData<Boolean>()
    val showToast: LiveData<Boolean> = _showToast


    fun onSignUpChange(name: String, email: String, password: String) {
        _name.value = name
        _email.value = email
        _password.value = password
        //TODO:Remove true from below. its just for testing and dont have to insert the email and password every time
        //_sigUpEnabled.value = isValidName(name) && isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidName(name: String): Boolean {
        return name.length > 2
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        _password.value!!.length > 8 && _password.value!!.contains(Regex("[A-Z]")) && _password.value!!.contains(
            Regex("[a-z]")
        ) && _password.value!!.contains(Regex("[0-9]"))

    fun onSignUpClick(navController: NavHostController) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val result = signUpUseCase(_name.value!!, _email.value!!, _password.value!!)

                if(result) {
                    Log.i("zDAM SignUP viewModel", "Navigate to Home")
                    _showToast.value = false
                    navController.navigate(Routes.Home.route)
                } else {
                    _showToast.value = true
                }
            } catch (e: Exception) {

                Log.e("xDAM SignUP viewModel", "Error during sign-up: ${e.message}")
                _showToast.value = true
            } finally {
                _isLoading.value = false
            }
        }
    }
}