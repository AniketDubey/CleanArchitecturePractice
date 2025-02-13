package com.example.eventnotificationapp.data.entities

data class NotificationResponseModel(
    val `data`: ArrayList<Data>,
    val message: String,
    val statusCode: Int
)
