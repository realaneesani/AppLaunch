package com.helium4.weatherapp.screen.user

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helium4.weatherapp.repository.UserRepository
import com.helium4.weatherapp.room.User
import com.helium4.weatherapp.room.UserRoomDatabase

class UserViewModel(application:Application): ViewModel() {


    val allUser: LiveData<List<User>>
    private val repository: UserRepository



    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)

        allUser = repository.allUser
    }
}