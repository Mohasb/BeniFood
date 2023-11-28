package com.example.benifood.componentsBase

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benifood.R

@Composable
fun ButtonBase(onclick: () -> Unit, isEnabled: Boolean, textValue: String) {
    Button(
        onClick = { onclick() },
        shape = RoundedCornerShape(size = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.tertiary,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ), enabled = isEnabled

    ) {
        Text(
            text = textValue, style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp,
            )
        )
    }
}

@Composable
fun ButtonBadge(
    onclick: () -> Unit,
    isEnabled: Boolean,
    textValue: String,
    idIconPainterResorce: Int,
    iconDescription: String,
    modifier: Modifier
) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = { onclick },
        shape = RoundedCornerShape(size = 8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary,),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.secondary,
        ), enabled = isEnabled
    ) {
        Image(
            painter = painterResource(id = idIconPainterResorce),
            contentDescription = iconDescription,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = textValue, modifier = Modifier.padding(start = 10.dp), style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                letterSpacing = 1.sp,
            )
        )
    }
}