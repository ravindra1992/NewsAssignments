package com.example.newsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsassignment.R
import com.example.newsassignment.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        initView()
    }

    private fun initView() {
        title_text.text= intent?.getStringExtra("title")?:""
        description.text = intent?.getStringExtra("description")?:"N.A"
        news.loadImage(intent?.getStringExtra("image_url")?:"N.A")
    }
}
