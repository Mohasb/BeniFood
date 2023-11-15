package com.example.benifood.componentsBase

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benifood.R

@Composable
fun BotomSignIn_Up() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Al registrarte estás aceptando nuestros",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Terminos y condiciones",
                modifier = Modifier.clickable { },
                style = TextStyle(
                    color = Color(0xFFFF0000)
                )
            )
            Text(text = " & ")
            Text(
                text = "Politica de privacidad",
                modifier = Modifier.clickable { },
                style = TextStyle(
                    color = Color(0xFFFF0000)
                )
            )
        }
        Text(
            text = "O conéctate con",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,

                )
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonBadge(
                onclick = { /*TODO*/ },
                isEnabled = true,
                textValue = "Facebook",
                idIconPainterResorce = R.drawable.ic_baseline_facebook,
                iconDescription = "Facebook icon",
                modifier = Modifier.weight(1f)
            )
            ButtonBadge(
                onclick = { /*TODO*/ },
                isEnabled = true,
                textValue = "Google",
                idIconPainterResorce = R.drawable.google,
                iconDescription = "Google icon",
                modifier = Modifier.weight(1f)
            )

        }
    }
}