package com.example.cleanarchitecturepractice.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {
    @Insert
    suspend fun insert(note: LocalNotification)

    @Update
    suspend fun update(note: LocalNotification)

    @Delete
    suspend fun delete(note: LocalNotification)

    @Query("SELECT * FROM LocalNFT")
    fun getAllLocalNotification(): Flow<List<LocalNotification>>
}