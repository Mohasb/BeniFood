package com.example.benifood.componentsBase

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseOutlinedTextField(
    value: String,
    onTextFieldChanged: (String) -> Unit,
    modifier: Modifier,
    labelValue: String,
    placeHolderValue: String,
    keyboardOptions: KeyboardOptions,
    icon: Painter,
    iconDescription: String
) {
    OutlinedTextField(value = value,
        onValueChange = { onTextFieldChanged(it) },
        modifier = modifier,
        label = { Text(text = labelValue) },
        placeholder = {
            Text(
                text = placeHolderValue
            )
        },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color(0xFF79747E),
        ),
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(icon, contentDescription = iconDescription)
            }
        })
}