package com.example.benifood.ui.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.benifood.R


@Composable
fun RestaurantContent(/*restaurante: Restaurante*/
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.temporal_kfc_bg),
                    contentDescription = "Image restaurant",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxHeight()
                )

                Column(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(30.dp)
                            .background(Color.Black.copy(alpha = 0.5f))
                    ) {
                        Text(
                            text = "KFC",
                            color = Color.Red,
                            style = TextStyle(/* your text style here */
                            ),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                Row {
                    Text(
                        text = "El mejor pollo",
                        color = Color.Blue,
                        modifier = Modifier
                            //.align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                    )
                }
            }
        }
    }
}
