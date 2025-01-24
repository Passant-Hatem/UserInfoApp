package com.example.userinfoapp.data

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.userinfoapp.modules.user.data.UserDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class UserDatabaseMigrationTest {

    private val TEST_DB = "migration-test"

    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        UserDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    @Throws(IOException::class)
    fun migrate1To2() {
        // Step 1: Create a database in version 1 and insert initial data
        var db = helper.createDatabase(TEST_DB, 1).apply {
            execSQL("INSERT INTO user (id, name, gender, age, jobTitle) VALUES (1, 'John', 'Male', 30, 'Developer')")
            close()
        }

        // Step 2: Run the migration and validate the schema
        db = helper.runMigrationsAndValidate(TEST_DB, 2, true, UserDatabase.MIGRATION_1_2)

        // Step 3: Query the database to validate the data
        val cursor = db.query("SELECT id, name, gender, age, jobTitle, nickname, address, maritalStatus FROM user WHERE id = 1")

        // Step 4: Assert the values
        if (cursor.moveToFirst()) {
            // Validate existing fields
            assert(cursor.getInt(cursor.getColumnIndexOrThrow("id")) == 1)
            assert(cursor.getString(cursor.getColumnIndexOrThrow("name")) == "John")
            assert(cursor.getString(cursor.getColumnIndexOrThrow("gender")) == "Male")
            assert(cursor.getInt(cursor.getColumnIndexOrThrow("age")) == 30)
            assert(cursor.getString(cursor.getColumnIndexOrThrow("jobTitle")) == "Developer")

            // Validate new fields with default values
            assert(cursor.getString(cursor.getColumnIndexOrThrow("nickname")) == "")
            assert(cursor.getString(cursor.getColumnIndexOrThrow("address")) == "")
            assert(cursor.getString(cursor.getColumnIndexOrThrow("maritalStatus")) == "Single")
        } else {
            throw AssertionError("No data found after migration!")
        }

        cursor.close()
    }
}

