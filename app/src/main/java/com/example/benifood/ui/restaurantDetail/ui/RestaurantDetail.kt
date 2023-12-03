package com.example.benifood.ui.restaurantDetail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun RestaurantDetail(navController: NavHostController, id: Int) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
            contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Restaurante: $id",
                //modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "En desarollo...",
                //modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }

}