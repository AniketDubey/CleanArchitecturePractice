package com.example.cleanarchitecturepractice.domain.usecase

import com.example.cleanarchitecturepractice.domain.mapper.toNotificationUiModel
import com.example.cleanarchitecturepractice.domain.repository.NotificationRepository
import com.example.cleanarchitecturepractice.presentation.uimodel.NotificationUIModel
import javax.inject.Inject

class NotificationUseCase @Inject constructor(private val notificationRepository: NotificationRepository) {
    suspend fun getAllNotification(): List<NotificationUIModel>{
        val notificationData = notificationRepository.getAllNotification().body()
        if(notificationData?.data.isNullOrEmpty()){
            return emptyList()
        }
        return notificationData!!.data.map { it.toNotificationUiModel() }
    }
}