package com.example.newsassignment

import com.example.newsassignment.DBInstance
import com.example.newsassignment.db.entity.NewsDao
import com.example.newsassignment.model.Article
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TestDataBase {
    var newsDao: NewsDao?=null

    @Before
    fun setUp(){
        newsDao = DBInstance.getInstance()
    }

    @Test
    fun deleteAllValueFromTable(){
        newsDao?.deleteAllNews()
        val data = newsDao?.getAllNews()
        Assert.assertEquals(0,data?.size)
    }


    @Test
    fun testInsertNewsDetailsInNewsTable(){
        val article = Article()
        article.author="Ravindra"
        article.description="Test db"
        article.title="Test"
        article.urlToImage="www.google.com"
        newsDao?.insert(article)

    }

}