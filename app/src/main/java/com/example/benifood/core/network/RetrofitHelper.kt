package com.example.benifood.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://clutrtqceergafdtqjeb.supabase.co/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}