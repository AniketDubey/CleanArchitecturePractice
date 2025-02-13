package com.example.cleanarchitecturepractice.domain.repository

import com.example.eventnotificationapp.data.entities.NotificationResponseModel
import retrofit2.Response

interface NotificationRepository {
    suspend fun getAllNotification(): Response<NotificationResponseModel>
}