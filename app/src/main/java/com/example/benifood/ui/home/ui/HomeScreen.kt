package com.example.benifood.ui.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.benifood.ui.home.ui.components.RestaurantCards
import com.example.benifood.ui.splashscreen.ui.AppName

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavHostController) {

    val listaRestaurant = viewModel.restaurants.observeAsState()

    Scaffold(topBar = { TopBar() }, bottomBar = { BottomBar() }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 80.dp)
        ) {

            RestaurantCards(listaRestaurant, navController)
        }
    })

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar() {
    CenterAlignedTopAppBar(title = {
        Row {
            AppName(32)
        }
    }, colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
    ), navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu",
                modifier = Modifier.size(100.dp)
            )
        }
    }, actions = {
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = "search",
            modifier = Modifier
                .size(50.dp)
                .clickable { })
    })
}

@Composable
fun BottomBar() {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, label = {
            Text(
                text = "HOME"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Home",
            )
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, label = {
            Text(
                text = "BUSCAR"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
            )
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, label = {
            Text(
                text = "CARRITO"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
            )
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, label = {
            Text(
                text = "CUENTA"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Person",
                modifier = Modifier.size(40.dp)
            )
        })


    }
}
