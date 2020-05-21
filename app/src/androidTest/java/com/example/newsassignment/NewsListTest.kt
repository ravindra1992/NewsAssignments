package com.example.newsassignment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.newsassignment.view.NewsActivity
import com.example.newsassignment.view.NewsListAdapter
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NewsListTest {
    @get:Rule
    val mNewsActivityTestRule = ActivityTestRule(NewsActivity::class.java)
    private lateinit var mNewsActivity:NewsActivity

    @Before
    fun setUp() {
        mNewsActivity=mNewsActivityTestRule.activity
    }

    @Test
    fun newsListScroll() {
        Thread.sleep(2000)
        testView(2)

    }

    private fun testView(position: Int) {
        onView(withId(R.id.news_list_recycler)).perform(actionOnItemAtPosition<NewsListAdapter.ViewHolder>(position,click()))
        Thread.sleep(1000)

    }

}