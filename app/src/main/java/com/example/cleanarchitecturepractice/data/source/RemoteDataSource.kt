package com.example.cleanarchitecturepractice.data.source

import com.example.eventnotificationapp.data.entities.NotificationResponseModel
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getRemoteNotification(): Response<NotificationResponseModel>
}