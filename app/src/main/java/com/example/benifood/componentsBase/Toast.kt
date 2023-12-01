package com.example.benifood.componentsBase

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ToastMessage(message: String) {
    val context  = LocalContext.current
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}