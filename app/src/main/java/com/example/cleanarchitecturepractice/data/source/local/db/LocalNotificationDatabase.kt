package com.example.cleanarchitecturepractice.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LocalNotification::class], version = 1)
abstract class LocalNotificationDatabase: RoomDatabase() {
    abstract fun localNotificationDao(): NotificationDao
    companion object {
        @Volatile
        private var INSTANCE: LocalNotificationDatabase? = null

        fun getDatabase(context: Context): LocalNotificationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalNotificationDatabase::class.java,
                    "local_notification_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}