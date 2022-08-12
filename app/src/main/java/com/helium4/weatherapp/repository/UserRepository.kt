package com.helium4.weatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.helium4.weatherapp.room.User
import com.helium4.weatherapp.room.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {

    val allUser: LiveData<List<User>> = userDao.getAllUser()
    val searchResult = MutableLiveData<List<User>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    fun insertUser(newUser: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insertUser(newUser)
        }
    }

    fun deleteUser(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.deleteUser(name)
        }
    }
}