package com.example.cleanarchitecturepractice.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturepractice.presentation.uimodel.NotificationUIModel
import com.example.cleanarchitecturepractice.domain.usecase.NotificationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewmodel @Inject constructor(private val notificationUseCase: NotificationUseCase): ViewModel() {
    val notificationUiList = MutableLiveData<List<NotificationUIModel>>()
    fun getAllNotification(){
        viewModelScope.launch {
            notificationUiList.postValue(notificationUseCase.getAllNotification())
        }
    }
}