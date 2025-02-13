package com.example.cleanarchitecturepractice.data.source

import com.example.cleanarchitecturepractice.data.api.Api
import com.example.eventnotificationapp.data.entities.NotificationResponseModel
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api:Api):RemoteDataSource {
    override suspend fun getRemoteNotification(): Response<NotificationResponseModel> {
        return api.getAllNotification("AUTH TOKEN")
    }
}