package com.example.benifood.ui.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random


val items = (1 .. 50).map {
    BoxProperties(
        height = Random.nextInt(200, 400).dp,
        color = Color(
            Random.nextInt(255),
            Random.nextInt(255),
            Random.nextInt(255),
            255
        )
    )
}


@Composable
fun RestaurantCards() {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalItemSpacing = 20.dp
    ) {
        items(items) { values ->
            GridItem(properties = values)
        }
    }
}



data class BoxProperties(
    val color: Color,
    val height: Dp
)

@Composable
fun GridItem(properties: BoxProperties) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(properties.height)
        //.background(properties.color)
    ) {
        RestaurantContent(/*restaurante*/)
    }
}
