package com.example.benifood.ui.signin.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.benifood.R
import com.example.benifood.componentsBase.BaseOutlinedTextField
import com.example.benifood.componentsBase.BotomSignIn_Up
import com.example.benifood.componentsBase.ButtonBase
import com.example.benifood.componentsBase.ToastMessage
import com.example.benifood.core.routes.Routes

@Composable
fun SignInScreen(viewModel: SignInViewModel, navController: NavHostController) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Loading()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            SignIn(viewModel, navController)
        }
    }
}

@Composable
fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.size(100.dp))
    }
}

@Composable
fun SignIn(viewModel: SignInViewModel, navController: NavHostController) {

    //TODO:Delete the initial values below. It's just to test and so you don't have to enter the email and password every time
    val email: String by viewModel.email.observeAsState(initial = "mha@gmail.com")
    val password: String by viewModel.password.observeAsState(initial = "Mha123456")
    val signInEnabled: Boolean by viewModel.sigInEnabled.observeAsState(initial = true)
    val showToast: Boolean by viewModel.showToast.observeAsState(initial = false)

    Column {
        Header(navController)
        Spacer(modifier = Modifier.padding(30.dp))
        Body(viewModel, email, password, signInEnabled, navController)
        Footer()
        if (showToast) ToastMessage(message = "Error en el Login:\nEmail o Password incorrecto")
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
    HeaderTextSignIn()
    NotRegistered(navController)
}

@Composable
fun Body(
    viewModel: SignInViewModel,
    email: String,
    password: String,
    signInEnabled: Boolean,
    navController: NavHostController
) {
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }


    BaseOutlinedTextField(
        value = email,
        onTextFieldChanged = { viewModel.onSignInChange(it, password) },
        modifier = Modifier.fillMaxWidth(),
        labelValue = "Email",
        placeHolderValue = "",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        icon = painterResource(id = R.drawable.baseline_clear_24),
        iconClick = { viewModel.onSignInChange("", password) },
        visualTransformation = VisualTransformation.None,
        iconDescription = "Clear"
    )
    Spacer(modifier = Modifier.padding(8.dp))
    BaseOutlinedTextField(
        value = password,
        onTextFieldChanged = { viewModel.onSignInChange(email, it) },
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
    Spacer(modifier = Modifier.padding(6.dp))
    ForgotPassword()
    Spacer(modifier = Modifier.padding(16.dp))
    SignInButton(signInEnabled, navController) { viewModel.onSignInClick(navController) }
    Spacer(modifier = Modifier.padding(18.dp))
}

@Composable
fun Footer() = BotomSignIn_Up()

//COMPONENTS
@Composable
fun HeaderTextSignIn() {
    Column {
        Text(
            text = "Inicia sesión",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.primary
            ),
        )
        Text(
            text = "mientras cocinamos",
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
fun NotRegistered(navController: NavHostController) {
    Row {
        Text(
            text = "¿No tienes cuenta? ",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.secondary
            ),
        )
        Text(text = "Registrate", style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.primary
        ), modifier = Modifier.clickable { navController.navigate(Routes.SignUp.route) })
    }
}

@Composable
fun ForgotPassword() {
    Text(
        text = "¿Olvidaste la contraseña?",
        Modifier
            .fillMaxWidth()
            .clickable { },
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.End
        )

    )
}

@Composable
fun SignInButton(
    signInEnabled: Boolean, navController: NavHostController, onSignInClicked: () -> Unit
) {
    ButtonBase(
        onclick = { onSignInClicked() },
        isEnabled = signInEnabled,
        textValue = "Iniciar Sesión"
    )
}