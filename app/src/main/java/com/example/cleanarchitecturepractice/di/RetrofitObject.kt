package com.example.cleanarchitecturepractice.di

import com.example.cleanarchitecturepractice.data.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    private val RetrofitInstance: Retrofit by lazy {
        Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()
    }

    private val nftApi by lazy {
        RetrofitInstance.create(Api::class.java)
    }
}