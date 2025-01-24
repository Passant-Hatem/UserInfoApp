package com.example.userinfoapp.modules.user.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.userinfoapp.modules.user.data.model.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 2,
    exportSchema = true
)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    companion object{
        const val DATABASE_NAME = "user_db"

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user ADD COLUMN nickname TEXT DEFAULT '' NOT NULL")
                database.execSQL("ALTER TABLE user ADD COLUMN address TEXT DEFAULT '' NOT NULL")
                database.execSQL("ALTER TABLE user ADD COLUMN maritalStatus TEXT DEFAULT 'Single' NOT NULL")
            }
        }

    }
}