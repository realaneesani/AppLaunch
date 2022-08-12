package com.helium4.weatherapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)


    @Query("SELECT * FROM usertable WHERE FName = :name")
    fun findUser(name: String): List<User>

    @Query("DELETE FROM usertable WHERE FName = :name")
    fun deleteUser(name: String)

    @Query("SELECT * FROM usertable")
    fun getAllUser(): LiveData<List<User>>

}