package com.example.eventnotificationapp.data.entities

data class Data(
    val createdAt: String,
    val createdBy: String,
    val description: String,
    val event: String,
    val id: String,
    val image: String,
    val isActive: Boolean,
    val isArchive: Boolean,
    val isRead: Boolean,
    val link: String,
    val modifiedBy: String,
    val `receiver`: String,
    val sender: String,
    val sourceType: String,
    val title: String,
    val type: String,
    val updatedAt: String,
    val userId: String,
    var nftDateObj: Long? = null
)
