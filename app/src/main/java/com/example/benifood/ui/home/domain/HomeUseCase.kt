package com.example.benifood.ui.home.domain

import com.example.benifood.ui.home.data.HomeRepository
import com.example.benifood.ui.home.data.network.response.RestaurantResponse
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val networkRepository: HomeRepository) {
    suspend operator fun invoke(): List<RestaurantResponse>
    {
        return networkRepository.getRestaurants()
    }
}