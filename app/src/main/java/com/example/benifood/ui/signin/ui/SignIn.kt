package com.example.benifood.ui.signin.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.benifood.R
import com.example.benifood.componentsBase.BotomSignIn_Up
import com.example.benifood.models.Routes

@Composable
fun SignInScreen(viewModel: SignInViewModel, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SignIn(Modifier.align(Alignment.Center), viewModel, navController)
    }
}

@Composable
fun SignIn(modifier: Modifier, viewModel: SignInViewModel, navController: NavHostController) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val signInEnabled: Boolean by viewModel.sigInEnabled.observeAsState(initial = false)


    Column(modifier = Modifier) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = "back",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable { navController.navigateUp() }
        )
        HeaderTextSignIn()
        NotRegistered(navController)
    }
    Column(modifier = modifier
        .padding(top = 300.dp)
        .fillMaxWidth()) {
        EmailField(
            modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), email
        ) { viewModel.onSignInChange(it, password) }
        Spacer(modifier = Modifier.padding(8.dp))
        PasswordField(
            modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), password
        ) { viewModel.onSignInChange(email, it) }
        Spacer(modifier = Modifier.padding(6.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        SignInButton(signInEnabled) { viewModel.onSignInSelected() }
        Spacer(modifier = Modifier.padding(18.dp))
        BotomSignIn_Up()
    }
}



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
                color = Color(0xFFFF0000),
            ),
        )
        Text(
            text = "mientras cocinamos",
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
fun NotRegistered(navController: NavHostController) {
    Row {
        Text(
            text = "¿No tienes cuenta? ",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
        )
        Text(text = "Registrate", style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(700),
            color = Color(0xFFFF0000),
        ), modifier = Modifier.clickable { navController.navigate(Routes.SignUp.route) })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(modifier: Modifier, email: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = modifier,
        label = { Text(text = "Email") },
        placeholder = {
            Text(
                text = "alguien@domain.com"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color(0xFF79747E),
        ),
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Clear, contentDescription = "Clear")
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(modifier: Modifier, password: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = modifier,
        label = { Text(text = "Contraseña") },
        placeholder = {
            Text(
                text = "***********"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color(0xFF79747E),

            ),
        trailingIcon = {
            IconButton(onClick = { /* Handle icon click if needed */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_visibility_24),
                    contentDescription = "Toggle Visibility"
                )
            }
        })
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Olvidaste la contraseña?", modifier.clickable { }, style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(700),
            color = Color(0xFFFF0000),
            textAlign = TextAlign.End
        )

    )
}

@Composable
fun SignInButton(signInEnabled: Boolean, onSignInSelected: () -> Unit) {
    Button(
        onClick = { onSignInSelected },
        shape = RoundedCornerShape(size = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ), enabled = signInEnabled

    ) {
        Text(
            text = "Iniciar Sesión", style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp,
            )
        )
    }
}