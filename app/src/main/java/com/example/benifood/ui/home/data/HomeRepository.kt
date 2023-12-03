package com.example.benifood.ui.home.data

import com.example.benifood.ui.home.data.network.HomeService
import com.example.benifood.ui.home.data.network.response.RestaurantResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeService) {
    suspend fun  getRestaurants() : List<RestaurantResponse> {
        return api.getRestaurants();
    }
}