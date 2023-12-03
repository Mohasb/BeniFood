package com.example.benifood.ui.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.benifood.ui.home.data.network.response.RestaurantResponse


@Composable
fun RestaurantCards(
    listaRestaurant: State<List<RestaurantResponse>?>,
    navController: NavHostController
) {


    val items = listaRestaurant.value.orEmpty().map { restaurant ->
        BoxProperties(
            listaRestaurant = listaRestaurant,
            restaurant = restaurant,
            navController = navController
        )
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(1),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalItemSpacing = 20.dp
    ) {


        items(items) { values ->
            GridItem(properties = values)
        }
    }
}


data class BoxProperties(
    val listaRestaurant: State<List<RestaurantResponse>?>,
    val restaurant: RestaurantResponse,
    val navController: NavHostController
)

@Composable
fun GridItem(properties: BoxProperties) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        RestaurantContent(restaurant = properties.restaurant, navController = properties.navController)
    }
}
