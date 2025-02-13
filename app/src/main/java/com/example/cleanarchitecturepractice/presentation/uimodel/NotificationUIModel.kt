package com.example.cleanarchitecturepractice.presentation.uimodel

data class NotificationUIModel(
    val nftIcon: String,
    val nftTitle: String,
    val nftDesc: String,
    val nftType: String,
    val isVisible: Boolean,
    val btnText: String,
    val btnColor: Int,
)