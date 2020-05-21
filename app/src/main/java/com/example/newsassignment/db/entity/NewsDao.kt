package com.example.newsassignment.db.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsassignment.model.Article

@Dao
interface NewsDao {
    @Insert
    fun saveAndUpdate(news: List<Article>)

    @Query("SELECT * FROM Article")
    fun getAllNews(): List<Article>

    @Query("DELETE FROM Article")
    fun deleteAllNews()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(news:Article)
}