package com.example.benifood.ui.splashscreen.ui

import android.os.Build.VERSION.SDK_INT
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.benifood.R
import com.example.benifood.componentsBase.ButtonBase
import kotlin.math.log

@Composable
fun SplashScreen(navController: NavHostController) {

    val imageLoader = ImageLoader.Builder(LocalContext.current).components {
        if (SDK_INT >= 28) {
            add(ImageDecoderDecoder.Factory())
        } else {
            add(GifDecoder.Factory())
        }
    }.build()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(R.drawable.splash_gif, imageLoader),
            contentDescription = "Spalsh gif",
            Modifier.size(500.dp)
        )
        Row {
            Text(
                text = "Beni", style = TextStyle(
                    fontSize = 64.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "Food", style = TextStyle(
                    fontSize = 64.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFF0000),
                )
            )
        }
        Text(text = "La mejor comida en tu puerta")
        ButtonBase(
            onclick = {
                navController.navigate("signin") }, isEnabled = true, textValue = "Comenzar"
        )
    }
}