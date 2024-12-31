package com.example.userinfoapp.modules.user.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userinfoapp.modules.user.data.model.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    companion object{
        const val DATABASE_NAME = "user_db"
    }

}