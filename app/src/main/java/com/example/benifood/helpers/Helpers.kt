package com.example.benifood.helpers

import android.os.Build
import android.view.Surface
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun isLandscape(): Boolean {
    val configuration = LocalContext.current
    val orientation = configuration.display?.rotation ?: 0
    return orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270
}