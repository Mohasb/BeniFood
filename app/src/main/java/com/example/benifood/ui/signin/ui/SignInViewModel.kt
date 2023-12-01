package com.example.benifood.ui.signin.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.benifood.core.routes.Routes
import com.example.benifood.ui.signin.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    //TODO:Delete the initial values below. It's just to test and so you don't have to enter the email and password every time
    private val _email = MutableLiveData<String>("mhaskimr@gmail.com")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>("Mha123456")
    val password: LiveData<String> = _password

    private val _sigInEnabled = MutableLiveData<Boolean>()
    val sigInEnabled: LiveData<Boolean> = _sigInEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _showToast = MutableLiveData<Boolean>()
    val showToast: LiveData<Boolean> = _showToast


    fun onSignInChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        //TODO:Remove true from below. its just for testing and dont have to insert the email and password every time
        //_sigInEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        _password.value!!.length > 8 && _password.value!!.contains(Regex("[A-Z]")) && _password.value!!.contains(
            Regex("[a-z]")
        ) && _password.value!!.contains(Regex("[0-9]"))

    fun onSignInClick(navController: NavHostController) {
        //Signin action
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val result = signInUseCase(_email.value!!, _password.value!!)

                if(result) {
                    Log.i("zDAM SignIn viewModel", "Navigate to Home")
                    _showToast.value = false
                    navController.navigate(Routes.Home.route)
                } else {
                    _showToast.value = true
                }
            } catch (e: Exception) {

                Log.e("xDAM SignIn viewModel", "Error during sign-in: ${e.message}")
                _showToast.value = true
            } finally {
                _isLoading.value = false
            }
        }

    }
}
