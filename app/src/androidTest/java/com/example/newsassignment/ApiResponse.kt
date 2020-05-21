package com.example.newsassignment

import androidx.test.rule.ActivityTestRule
import com.example.newsassignment.view.NewsActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ApiResponse {
    @get:Rule
    val mNewsActivityTestRule = ActivityTestRule(NewsActivity::class.java)
    private lateinit var mNewsActivity: NewsActivity

    @Before
    fun setUp() {
        mNewsActivity=mNewsActivityTestRule.activity
    }

    @Test
    fun getNewsInfo() {
        Thread.sleep(5000)
        val expectedValue=mNewsActivity.news[0].author!!
        Assert.assertEquals("PTI",expectedValue)
    }

}