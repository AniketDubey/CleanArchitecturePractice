package com.example.cleanarchitecturepractice.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecturepractice.databinding.ActivityMainBinding
import com.example.cleanarchitecturepractice.presentation.ui.adater.NotificationListAdapter
import com.example.cleanarchitecturepractice.presentation.viewmodel.NotificationViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: NotificationViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel = ViewModelProvider(this)[NotificationViewmodel::class.java]
        viewModel.notificationUiList.observe(this){
            Log.d("TAG", "onCreate: $it")
        }
        viewModel.getAllNotification()
        binding.notificationRV.layoutManager = LinearLayoutManager(this)
    }
}