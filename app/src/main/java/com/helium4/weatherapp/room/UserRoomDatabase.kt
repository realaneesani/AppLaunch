package com.helium4.weatherapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [(User::class)], version = 1)

abstract class UserRoomDatabase: RoomDatabase() {


    abstract fun userDao():UserDao

    companion object {
        private var INSTANCE :UserRoomDatabase?= null

        fun getInstance (context: Context):UserRoomDatabase{

            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "user_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
