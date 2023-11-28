package com.example.benifood.ui.signup.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    //LiveData
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _sigUpEnabled = MutableLiveData<Boolean>()
    val sigUpEnabled: LiveData<Boolean> = _sigUpEnabled


    fun onSignUpChange(name: String, email: String, password: String) {
        _name.value = name
        _email.value = email
        _password.value = password

        _sigUpEnabled.value = isValidName(name) && isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidName(name: String): Boolean {
        return name.length > 2
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

    fun onSignUpClick() {
        //Signin action
        Log.i("LOG", "Registro click")
    }
}