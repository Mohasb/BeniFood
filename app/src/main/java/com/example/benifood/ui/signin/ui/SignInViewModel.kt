package com.example.benifood.ui.signin.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _sigInEnabled = MutableLiveData<Boolean>()
    val sigInEnabled: LiveData<Boolean> = _sigInEnabled


    fun onSignInChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        //_sigInEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    /*
    * ^               # start-of-string
    (?=.*[0-9])       # a digit must occur at least once
    (?=.*[a-z])       # a lower case letter must occur at least once
    (?=.*[A-Z])       # an upper case letter must occur at least once
    (?=.*[@#$%^&+=])  # a special character must occur at least once you can replace with your special characters
    (?=\\S+$)         # no whitespace allowed in the entire string
    .{4,}             # anything, at least six places though
    $                 # end-of-string
    *
 */
    private fun isValidPassword(password: String): Boolean =
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&+=])(?=\\S+$).{4,}$")
            .matcher(password).matches()

    fun onSignInClick() {
        //Signin action
        viewModelScope.launch {
            //val result = signInUseCase()
            //Log.i("LOG", result.toString())
            /*if (result) {
                Log.i("LOG", "Login click")
            }*/
        }

    }
}
