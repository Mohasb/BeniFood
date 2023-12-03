package com.example.benifood.ui.home.data.network

import com.example.benifood.ui.home.data.network.response.RestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeService @Inject constructor(private val homeClient: HomeClient) {

    suspend fun getRestaurants():List<RestaurantResponse> {
        return withContext(Dispatchers.IO){
            val restaurantes = homeClient.getRestaurants()
            restaurantes
        }
    }

}