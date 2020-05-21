package com.example.newsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsassignment.R
import com.example.newsassignment.model.Article
import com.example.newsassignment.utils.showSnackBar
import com.example.newsassignment.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {
    //

    private val newsViewModel: NewsViewModel by viewModel()
    var news = mutableListOf<Article>()
    private lateinit var mNewsListAdapter: NewsListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
        setViewModel()
    }

    private fun setViewModel() {
        newsViewModel.getNewsInfo().observe(this, Observer {
            if (it != null) {
                showProgressBar(false)
                news = it as MutableList<Article>
                notifyAdapter()
            }
        })

        newsViewModel.getErrorMessage().observe(this, Observer {
            showProgressBar(false)
            showSnackBar(it)
        })
    }

    private fun notifyAdapter() {

        mNewsListAdapter=NewsListAdapter(news)
        news_list_recycler.adapter = mNewsListAdapter
        mNewsListAdapter.notifyDataSetChanged()
    }

    private fun showProgressBar(b: Boolean) {

        if (b) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun setUI() {
        news_list_recycler.run {
            layoutManager = LinearLayoutManager(this@NewsActivity)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }


    }
}
