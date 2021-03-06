package com.example.appacademia.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataEntity::class], version = 5)
abstract class DatabaseInstanceService : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "database"
        private var INSTANCE: DatabaseInstanceService? = null

        private fun createDatabase(context: Context): DatabaseInstanceService =
            Room.databaseBuilder(context, DatabaseInstanceService::class.java, DATABASE_NAME)
                .allowMainThreadQueries().build()

        fun getInstance(context: Context): DatabaseInstanceService =
            (INSTANCE ?: createDatabase(context).also { INSTANCE = it })

    }

    abstract fun getDao(): DataDAO


}