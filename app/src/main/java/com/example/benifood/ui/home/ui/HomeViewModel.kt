package com.example.benifood.ui.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benifood.ui.home.data.network.response.RestaurantResponse
import com.example.benifood.ui.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val homeUseCase: HomeUseCase) : ViewModel() {

    private val _restaurants = MutableLiveData<List<RestaurantResponse>>()
    val restaurants : LiveData<List<RestaurantResponse>> = _restaurants

    init {
        viewModelScope.launch {
            try {
                val restaurants = homeUseCase()
                _restaurants.postValue(restaurants.take(4))
            } catch (e: IOException) {

            }
        }
    }






}
