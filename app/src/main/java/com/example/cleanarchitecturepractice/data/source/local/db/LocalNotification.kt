package com.example.cleanarchitecturepractice.data.source.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocalNFT")
data class LocalNotification(
    @PrimaryKey(autoGenerate = true)
    val notificationId: Int,
    val notificationTitle: String,
    val notificationBody: String,
    val notificationBanner: String
)