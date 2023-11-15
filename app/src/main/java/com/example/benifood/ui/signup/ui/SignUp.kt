package com.example.benifood.ui.signup.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.benifood.R
import com.example.benifood.componentsBase.BaseOutlinedTextField
import com.example.benifood.componentsBase.BotomSignIn_Up
import com.example.benifood.componentsBase.ButtonBase
import com.example.benifood.models.Routes.*

@Composable
fun SignUpScreen(viewModel: SignUpViewModel, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        SignUp(Modifier.align(Alignment.Center), viewModel, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(modifier: Modifier, viewModel: SignUpViewModel, navController: NavHostController) {
    Column(modifier = Modifier) {
        Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = "back",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable { navController.navigateUp() })
        HeaderTextSignUp()
        AlreadyRegisteredText(navController)
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            BaseOutlinedTextField(
                value = "",
                onTextFieldChanged = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                labelValue = "Nombre completo",
                placeHolderValue = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                icon = painterResource(id = R.drawable.baseline_clear_24),
                iconDescription = "Clear"
            )
            BaseOutlinedTextField(
                value = "",
                onTextFieldChanged = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                labelValue = "Email",
                placeHolderValue = "alguien@domain.com",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                icon = painterResource(id = R.drawable.baseline_clear_24),
                iconDescription = "Clear"
            )
            BaseOutlinedTextField(
                value = "",
                onTextFieldChanged = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                labelValue = "Password",
                placeHolderValue = "**********",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                icon = painterResource(id = R.drawable.outline_visibility_24),
                iconDescription = "Clear"
            )
            Spacer(modifier = Modifier.padding(16.dp))
            ButtonBase(onclick = { /*TODO*/ }, isEnabled = true, textValue = "Registrarse")
            Spacer(modifier = Modifier.padding(16.dp))


        }
        BotomSignIn_Up()
    }
}








@Composable
fun HeaderTextSignUp() {
    Column {
        Text(
            text = "Vamos a",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            ),
        )
        Row {
            Text(
                text = "Registrarte",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFF0000),
                ),
            )
            Text(
                text = ",",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                ),
            )
        }
        Text(
            text = "la comida espera",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            ),
        )
    }
}

@Composable
fun AlreadyRegisteredText(navController: NavHostController) {
    Row {
        Text(
            text = "¿Ya tienes cuenta? ",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
        )
        Text(text = "Inicia sesión", style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(700),
            color = Color(0xFFFF0000),
        ), modifier = Modifier.clickable { navController.navigate(SignIn.route) })
    }
}

