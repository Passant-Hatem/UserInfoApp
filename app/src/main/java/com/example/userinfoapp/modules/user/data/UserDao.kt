package com.example.userinfoapp.modules.user.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userinfoapp.modules.user.data.model.UserEntity
import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Int): Flow<UserEntity?>

    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User): Long
}
