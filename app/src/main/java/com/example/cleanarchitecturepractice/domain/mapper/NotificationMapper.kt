package com.example.cleanarchitecturepractice.domain.mapper

import com.example.cleanarchitecturepractice.R
import com.example.cleanarchitecturepractice.presentation.uimodel.NotificationUIModel
import com.example.eventnotificationapp.data.entities.Data

fun Data.toNotificationUiModel() = NotificationUIModel(
    nftIcon = image,
    nftTitle = title,
    nftDesc = description,
    nftType = type,
    isVisible = true,
    btnText = "Butotn",
    btnColor = R.color.white
)