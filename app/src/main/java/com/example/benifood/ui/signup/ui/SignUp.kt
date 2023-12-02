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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.benifood.R
import com.example.benifood.componentsBase.BaseOutlinedTextField
import com.example.benifood.componentsBase.BotomSignIn_Up
import com.example.benifood.componentsBase.ButtonBase
import com.example.benifood.componentsBase.ToastMessage
import com.example.benifood.core.routes.Routes.*
import com.example.benifood.ui.signin.ui.Loading
import com.example.benifood.ui.signin.ui.SignInButton

@Composable
fun SignUpScreen(viewModel: SignUpViewModel, navController: NavHostController) {

    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Loading()
    } else {
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


}

@Composable
fun SignUp(modifier: Modifier, viewModel: SignUpViewModel, navController: NavHostController) {

    val name: String by viewModel.name.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val signInEnabled: Boolean by viewModel.sigUpEnabled.observeAsState(initial = true)
    val password: String by viewModel.password.observeAsState(initial = "")
    val showToast: Boolean by viewModel.showToast.observeAsState(initial = false)


    Column {
        Header(navController)
        Spacer(modifier = Modifier.padding(30.dp))
        Body(viewModel, name, email, password, signInEnabled, navController)
        Footer()
        if (showToast) ToastMessage(message = "Error en el Registro :\nEmail o Password incorrecto")
    }
}

@Composable
fun Header(navController: NavHostController) {
    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
        contentDescription = "back",
        tint = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .clickable { navController.navigateUp() })
    HeaderTextSignUp()
    AlreadyRegisteredText(navController)
}

@Composable
fun Body(
    viewModel: SignUpViewModel,
    name: String,
    email: String,
    password: String,
    signUpEnabled: Boolean,
    navController: NavHostController
) {

    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }


    BaseOutlinedTextField(
        value = name,
        onTextFieldChanged = { viewModel.onSignUpChange(it, email, password) },
        modifier = Modifier.fillMaxWidth(),
        labelValue = "Nombre completo",
        placeHolderValue = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        icon = painterResource(id = R.drawable.baseline_clear_24),
        iconClick = { viewModel.onSignUpChange("", email, password) },
        visualTransformation = VisualTransformation.None,
        iconDescription = "Clear name"
    )
    BaseOutlinedTextField(
        value = email,
        onTextFieldChanged = { viewModel.onSignUpChange(name, it, password) },
        modifier = Modifier.fillMaxWidth(),
        labelValue = "Email",
        placeHolderValue = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        icon = painterResource(id = R.drawable.baseline_clear_24),
        iconClick = { viewModel.onSignUpChange(name, "", password) },
        visualTransformation = VisualTransformation.None,
        iconDescription = "Clear email"
    )
    BaseOutlinedTextField(
        value = password,
        onTextFieldChanged = { viewModel.onSignUpChange(name, email, it) },
        modifier = Modifier.fillMaxWidth(),
        labelValue = "Password",
        placeHolderValue = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        icon = if (passwordVisibility) {
            painterResource(id = R.drawable.outline_visibility_off_24)
        } else {
            painterResource(id = R.drawable.outline_visibility_24)
        },
        iconClick = { passwordVisibility = !passwordVisibility },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        iconDescription = "Hide/Show pwd"
    )
    Spacer(modifier = Modifier.padding(16.dp))
    SignUpButton(signUpEnabled, navController) { viewModel.onSignUpClick(navController) }

    //ButtonBase(onclick = { onSignUpClick() }, isEnabled = true, textValue = "Registrarse")
    Spacer(modifier = Modifier.padding(16.dp))
}

@Composable
fun SignUpButton(
    signUpEnabled: Boolean, navController: NavHostController, onSignUpClick: () -> Unit
) {
    ButtonBase(
        onclick = { onSignUpClick() }, isEnabled = signUpEnabled, textValue = "Registrarse"
    )
}

@Composable
fun Footer() = BotomSignIn_Up()


//Components
@Composable
fun HeaderTextSignUp() {
    Column {
        Text(
            text = "Vamos a",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.secondary
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
                    color = MaterialTheme.colorScheme.secondary
                ),
            )
        }
        Text(
            text = "la comida espera",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.secondary
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
                color = MaterialTheme.colorScheme.secondary
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

