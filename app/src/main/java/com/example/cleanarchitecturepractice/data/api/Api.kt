package com.example.cleanarchitecturepractice.data.api

import com.example.eventnotificationapp.data.entities.NotificationResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface Api {

    @GET("event/api/v1/notification/MOBILE")
    suspend fun getAllNotification(@Header("Authorization") token: String): Response<NotificationResponseModel>
}