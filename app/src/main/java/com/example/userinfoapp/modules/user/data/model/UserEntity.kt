package com.example.userinfoapp.modules.user.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.userinfoapp.modules.user.domain.model.User

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "jobTitle")
    val jobTitle: String,
)

fun UserEntity.toDomain() = User(name, gender, age, jobTitle)