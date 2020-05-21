package com.example.newsassignment.db.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.newsassignment.App
import com.example.newsassignment.db.entity.NewsDao
import com.example.newsassignment.model.Article
import com.example.newsassignment.utils.Constants.db_name


@Database(entities = [Article::class], version = 1)
abstract class DbCache : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    companion object {
        @Volatile
        private var INSTANCE: DbCache? = null
         fun getInstance(): DbCache =
            INSTANCE
                ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(
                        App.appContext!!
                    )
                        .also { INSTANCE = it }
            }
        private fun buildDatabase(context: Context) =
            databaseBuilder(context.applicationContext, DbCache::class.java, db_name).build()
    }
}