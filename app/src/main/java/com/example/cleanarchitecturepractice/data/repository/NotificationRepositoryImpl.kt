package com.example.cleanarchitecturepractice.data.repository

import com.example.cleanarchitecturepractice.data.source.RemoteDataSource
import com.example.cleanarchitecturepractice.domain.repository.NotificationRepository
import com.example.eventnotificationapp.data.entities.NotificationResponseModel
import retrofit2.Response
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
):NotificationRepository {
    override suspend fun getAllNotification(): Response<NotificationResponseModel> {
        val remoteNotificationData = remoteDataSource.getRemoteNotification()
        return remoteNotificationData
    }
}